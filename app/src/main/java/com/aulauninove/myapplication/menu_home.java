package com.aulauninove.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.aulauninove.myapplication.pojo.Saloes;

public class menu_home extends AppCompatActivity {

    ImageButton btHomeBuscaS, btHomeDados, btHomeReservas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_home);

        ////////////////////////////////////////////////////////
        Intent sal = getIntent();
        Saloes[] saloes;
        saloes = (Saloes[]) sal.getSerializableExtra("saloes");
        if(saloes == null) {
            EditarJson editarJson = new EditarJson();
            saloes = editarJson.getSaloes();
        }
        ////////////////////////////////////////////////////////

        btHomeBuscaS = findViewById(R.id.imageButtonBusca);
        btHomeDados = findViewById(R.id.imageButtonDados);
        btHomeReservas = findViewById(R.id.imageButtonReservas);


        Saloes[] finalSaloes = saloes;
        btHomeBuscaS.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itHomeEntrar = new Intent(getApplicationContext(), busca_saloes.class);
                itHomeEntrar.putExtra("saloes", finalSaloes);
                startActivity(itHomeEntrar);
            }
        }));

        btHomeDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itHomeDados = new Intent (getApplicationContext(), meus_dados.class);
                startActivity(itHomeDados);
            }
        });

        btHomeReservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itReservas = new Intent(getApplicationContext(),Saloes_disp.class);
                startActivity(itReservas);
            }
        });

    }
}