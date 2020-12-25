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

import com.aulauninove.myapplication.utils.Banco;
import com.aulauninove.myapplication.utils.Validacao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    //Variaveis
    EditText varEmail, varSenha;
    Button btnLogin, btnCadastro;
    SQLiteDatabase db;
    String email, senha, nome;
    Integer id, teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        varEmail = findViewById(R.id.impEmail);
        varSenha = findViewById(R.id.impSenha);
        btnCadastro = findViewById(R.id.btCriarC);
        btnLogin =  findViewById(R.id.btEntrar);

        // abrir o banco de dados
        db = openOrCreateDatabase(
                Banco.banco(),
                Context.MODE_PRIVATE,
                null);

        SharedPreferences sharedPreferences = getSharedPreferences(
                "prefs", Context.MODE_PRIVATE);

        teste = sharedPreferences.getInt("id",555);
        if(teste != 555){
            Intent inicio = new Intent(getApplicationContext(),menu_home.class);
            startActivity(inicio);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues dados = new ContentValues();
                Validacao val = new Validacao();

                // Criar a tabela no banco de dados, caso ela não exista
                db.execSQL(Banco.criaTabela());

                //Verifica o email digitado
                if (val.email(varEmail.getText().toString())) {
                    email = varEmail.getText().toString();
                } else {
                    Toast.makeText(MainActivity.this, "Verifique o campo \"Email\" e tente novamente",
                            Toast.LENGTH_LONG).show();
                }

                //Verifica a senha digitada
                if(varSenha.getText().toString().length() > 1) {
                    MessageDigest m = null;
                    try {
                        m = MessageDigest.getInstance("SHA-256");
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    assert m != null;
                    m.update(varSenha.getText().toString().getBytes(), 0, varSenha.getText().toString().length());
                    senha = new BigInteger(1,m.digest()).toString(16);
                } else {
                    Toast.makeText(MainActivity.this, "Verifique o campo \"Senha\" e tente novamente",
                            Toast.LENGTH_SHORT).show();
                }
                //Verifica se o usuaro existe no banco de dados
                Cursor cursor = db.rawQuery("SELECT usuario.id , usuario.email, usuario.senha  FROM " + Banco.tabela() + " " +
                        "WHERE email='"+email+"'AND senha='"+senha+"'",null);
                //Login
                if(cursor.moveToFirst()){
                    id = cursor.getInt(0);
                    nome = cursor.getString(1);
                    Toast.makeText(MainActivity.this, "Login realizado com sucesso!",
                            Toast.LENGTH_SHORT).show();

                    SharedPreferences sharedPreferences = getSharedPreferences(
                            "prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putInt("id",id);

                    editor.commit();

                    Intent inicio = new Intent(getApplicationContext(),menu_home.class);
                    startActivity(inicio);

                } else {
                    Toast.makeText(MainActivity.this, "Usuario não cadastrado",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastro = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(cadastro);
            }
        });

    }
}