package com.aulauninove.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.aulauninove.myapplication.pojo.Horarios;
import com.aulauninove.myapplication.pojo.Horarios_Reservas;
import com.aulauninove.myapplication.utils.Banco;

import java.util.ArrayList;

public class Saloes_disp extends AppCompatActivity {

    Button btHome;
    ListView listViewReservas;
    SQLiteDatabase db;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saloes_disp);

        int pos = 0;

        //Traz o id do usuario logado
        SharedPreferences sharedPreferences = getSharedPreferences(
                "prefs", Context.MODE_PRIVATE);
        id = sharedPreferences.getInt("id", 0);

        ArrayList<Horarios_Reservas> reservas = new ArrayList<>();

        listViewReservas = findViewById(R.id.listViewReservas);
        btHome = findViewById(R.id.btHome);

        ArrayList<String> reservasArrayList = new ArrayList<>();

        // verificação do banco
        db = openOrCreateDatabase(
                Banco.banco(),
                Context.MODE_PRIVATE,
                null);

        // Criar a tabela no banco de dados, caso ela não exista
        db.execSQL(Banco.criaTabelaReserva());

        //verifica se o id não esta vazio e executa o SELECT no banco
        if (id != 0) {
            Cursor cursor = db.rawQuery("SELECT * FROM " + Banco.tabelaReserva() + " " +
                    "WHERE id='" + id + "'", null);

            while(cursor.moveToNext()){
                reservas.add(new Horarios_Reservas());
               reservas.get(pos).setId(cursor.getInt(0));
               reservas.get(pos).setHora(cursor.getString(1));
               reservas.get(pos).setSalao(cursor.getString(2));
               reservas.get(pos).setProfisisonal(cursor.getString(3));
               reservas.get(pos).setDia(cursor.getString(4));

                reservasArrayList.add(reservas.get(pos).allReserva());

                pos++;
            }
        }

            final ArrayAdapter<String> reservasArrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                    android.R.layout.simple_list_item_1, reservasArrayList);

            listViewReservas.setAdapter(reservasArrayAdapter);

            listViewReservas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                   Horarios_Reservas reservas1 = reservas.get(i);
                   String dia = reservas1.getDia();
                   String hora = reservas1.getHora();
                    db.delete(
                            Banco.tabelaReserva(),
                            "dia=? AND hora=?" ,
                            new String[]{dia,hora});

                    Toast.makeText(Saloes_disp.this, "Registro Excluido com sucesso.",
                            Toast.LENGTH_SHORT).show();

                    Intent itHome = new Intent(getApplicationContext(), menu_home.class);
                    startActivity(itHome);

                    return true;
                }
            });

            btHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent itHome = new Intent(getApplicationContext(), menu_home.class);
                    startActivity(itHome);
                }
            });
        }
}