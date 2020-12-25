package com.aulauninove.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aulauninove.myapplication.pojo.Saloes;
import com.aulauninove.myapplication.pojo.UsuarioLogado;
import com.aulauninove.myapplication.utils.Banco;
import com.aulauninove.myapplication.utils.Validacao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class meus_dados extends AppCompatActivity {

    //Variaveis
    EditText varNome, varCelular, varEmail, varSenha, varCep;
    Button btnAtualizar, btnSair;
    String  nome;
    SQLiteDatabase db;
    Integer erro, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_dados);

        UsuarioLogado uLogado = new UsuarioLogado();

        varNome = findViewById(R.id.editNomeDados);
        varSenha = findViewById(R.id.editSenhaDados);
        varEmail = findViewById(R.id.editEmailDados);
        varCelular = findViewById(R.id.editCelularDados);
        varCep = findViewById(R.id.editCepDados);
        btnAtualizar = findViewById(R.id.buttonAtualizar);
        btnSair = findViewById(R.id.buttonSair);


        erro = 0;

        //Traz o id do usuario logado
        SharedPreferences sharedPreferences = getSharedPreferences(
                "prefs", Context.MODE_PRIVATE);
        id = sharedPreferences.getInt("id",0);

        //abre o banco de dados
        db = openOrCreateDatabase(
                Banco.banco(),
                Context.MODE_PRIVATE,
                null);

        //verifica se o id não esta vazio e executa o SELECT no banco
        if(id != 0){
            Cursor cursor = db.rawQuery("SELECT * FROM " + Banco.tabela() + " " +
                    "WHERE id='"+id+"'",null);

            if(cursor.moveToFirst()){
                uLogado.setId(cursor.getInt(0));
                uLogado.setNome(cursor.getString(1));
                uLogado.setCep(cursor.getString(2));
                uLogado.setCelular(cursor.getString(3));
                uLogado.setEmail(cursor.getString(4));
            }

            varNome.setText(uLogado.getNome());
            varEmail.setText(uLogado.getEmail());
            varCelular.setText(uLogado.getCelular());
            varCep.setText(uLogado.getCep());
        }

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                erro = 0;

                //Criação de um content values para incluir os dados no banco.
                ContentValues dados = new ContentValues();
                Validacao val = new Validacao();

                //Insere o nome no content values
                if (val.nome(varNome.getText().toString())) {
                    dados.put("nome", varNome.getText().toString());
                } else {
                    Toast.makeText(meus_dados.this, "Verifique o campo \"Nome\" e tente novamente",
                            Toast.LENGTH_SHORT).show();
                    erro++;
                }

                //Insere o celular no content values
                if (val.celular(varCelular.getText().toString())) {
                    dados.put("celular", varCelular.getText().toString());
                } else {
                    Toast.makeText(meus_dados.this, "Verifique o campo \"Celular\" e tente novamente",
                            Toast.LENGTH_SHORT).show();
                    erro++;
                }

                //insere o cep no content values
                if (val.cep(varCep.getText().toString())) {
                    dados.put("cep", varCep.getText().toString());
                } else {
                    Toast.makeText(meus_dados.this, "Verifique o campo \"Cep\" e tente novamente",
                            Toast.LENGTH_SHORT).show();
                    erro++;
                }

                //Insere o Email no content valies
                if (val.email(varEmail.getText().toString())) {
                    dados.put("email", varEmail.getText().toString());
                } else {
                    Toast.makeText(meus_dados.this, "Verifique o campo \"Email\" e tente novamente",
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
                    Toast.makeText(meus_dados.this, "Verifique o campo \"Senha\" e tente novamente",
                            Toast.LENGTH_SHORT).show();
                    erro++;
                }
                if(erro == 0){
                    db.update(
                            Banco.tabela(),
                            dados,
                            "id=?",
                            new String[]{String.valueOf(id)});
                    Toast.makeText(
                            meus_dados.this,
                            "Usuario atualizado com sucesso",
                            Toast.LENGTH_SHORT).show();

                    Intent home = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(home);

                }

            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Limpa o arquivo shared prefs e retorna para a home
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
        });
    }
}