package com.aulauninove.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aulauninove.myapplication.utils.Banco;
import com.aulauninove.myapplication.utils.Validacao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cadastro extends AppCompatActivity {

    //Variaveis
    EditText varNome, varCelular, varEmail, varSenha, varCep;
    Button btnConfirma;
    String teste, senha;
    SQLiteDatabase db;
    Integer erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        varNome = findViewById(R.id.impNomeCadastro);
        varSenha = findViewById(R.id.impSenhaCadastro);
        varEmail = findViewById(R.id.impEmailCadastro);
        varCelular = findViewById(R.id.impCelularCadastro);
        varCep = findViewById(R.id.impCepCadastro);
        btnConfirma = findViewById(R.id.buttonconfirmaCadastro);


        btnConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                erro = 0;

                db = openOrCreateDatabase(
                        Banco.banco(),
                        Context.MODE_PRIVATE,
                        null);

                // Criar a tabela no banco de dados, caso ela não exista
                db.execSQL(Banco.criaTabela());

                //Criação de um content values para incluir os dados no banco.

                ContentValues dados = new ContentValues();
                Validacao val = new Validacao();

                //Insere o nome no content values
                if (val.nome(varNome.getText().toString())) {
                    dados.put("nome", varNome.getText().toString());
                } else {
                    Toast.makeText(Cadastro.this, "Verifique o campo \"Nome\" e tente novamente",
                            Toast.LENGTH_SHORT).show();
                    erro++;
                }

                //Insere o celular no content values
                if (val.celular(varCelular.getText().toString())) {
                    dados.put("celular", varCelular.getText().toString());
                } else {
                    Toast.makeText(Cadastro.this, "Verifique o campo \"Celular\" e tente novamente",
                            Toast.LENGTH_SHORT).show();
                    erro++;
                }

                //insere o cep no content values
                if (val.cep(varCep.getText().toString())) {
                    dados.put("cep", varCep.getText().toString());
                } else {
                    Toast.makeText(Cadastro.this, "Verifique o campo \"Cep\" e tente novamente",
                            Toast.LENGTH_SHORT).show();
                    erro++;
                }

                //Insere o Email no content valies
                if (val.email(varEmail.getText().toString())) {
                    dados.put("email", varEmail.getText().toString());
                } else {
                    Toast.makeText(Cadastro.this, "Verifique o campo \"Email\" e tente novamente",
                            Toast.LENGTH_SHORT).show();
                    erro++;
                }

                //Insere a senha no content values
                if(varSenha.getText().toString().length() > 1) {
                    MessageDigest m = null;
                    try {
                        m = MessageDigest.getInstance("SHA-256");
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    assert m != null;
                    m.update(varSenha.getText().toString().getBytes(), 0, varSenha.getText().toString().length());
                    dados.put("senha",new BigInteger(1,m.digest()).toString(16));
                } else {
                    Toast.makeText(Cadastro.this, "Verifique o campo \"Senha\" e tente novamente",
                            Toast.LENGTH_SHORT).show();
                    erro++;
                }

                if(erro == 0){
                    // inserir no banco
                    db.insert(
                            Banco.tabela(),
                            null,
                            dados
                    );
                    Toast.makeText(
                            Cadastro.this,
                            "Registro inserido com sucesso",
                            Toast.LENGTH_SHORT).show();


                    SharedPreferences sharedPreferences = getSharedPreferences(
                            "prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.commit();

                    Intent home = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(home);
                }

            }
        });

    }

}