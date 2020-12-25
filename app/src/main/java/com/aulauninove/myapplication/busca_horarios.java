package com.aulauninove.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aulauninove.myapplication.pojo.Horarios;
import com.aulauninove.myapplication.pojo.Saloes;

import java.util.ArrayList;

public class busca_horarios extends AppCompatActivity {

    ListView horariosListView;
    ArrayList<String> horariosArrayList;
    Horarios varHorarios;
    Saloes[] saloes;
    Integer pos, posProf, i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_horarios);

        horariosListView = findViewById(R.id.listView_Horarios);

        Intent horarios = getIntent();
        pos = horarios.getIntExtra("pos",0);
        posProf =horarios.getIntExtra("posProf",0);

        ////////////////////////////////////////////////////////
        Intent sal = getIntent();
        Saloes[] saloes;
        saloes = (Saloes[]) sal.getSerializableExtra("saloes");
        if(saloes == null) {
            EditarJson editarJson = new EditarJson();
            saloes = editarJson.getSaloes();
        }
        ////////////////////////////////////////////////////////


        horariosArrayList = saloes[pos].getProfissionais()[posProf].getHorarios().getHorarios();
        ////////////////////////////////////////////////////////


        // Configurando a ListView (Lista de Objetos)
        final ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                horariosArrayList);

        //conectar a listView com o Adapter
        horariosListView.setAdapter(adaptador);

        Saloes[] finalSaloes = saloes;
        horariosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Intent calendar = new Intent(getApplicationContext(),busca_Dias.class);
             calendar.putExtra("Hora", horariosArrayList.get(position));
             calendar.putExtra("pos",pos);
             calendar.putExtra("posProf",posProf);
             calendar.putExtra("saloes", finalSaloes);
             startActivity(calendar);
            }
        });



    }
}