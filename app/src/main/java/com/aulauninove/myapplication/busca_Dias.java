package com.aulauninove.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.aulauninove.myapplication.pojo.Horarios_Reservas;
import com.aulauninove.myapplication.pojo.Saloes;
import com.aulauninove.myapplication.utils.Banco;
import com.aulauninove.myapplication.utils.Validacao;
import com.google.gson.Gson;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class busca_Dias extends AppCompatActivity {

    CalendarView calendar;
    Button btAgendar;
    long  data_selecionada;
    int dia_selecionado=0;
    int mes_selecionado=0;
    int ano_selecionado=0;
    int dia_atual;
    int mes_atual;
    int ano_atual;
    int pos;
    int posProf;
    int i;
    int erro = 1;
    int ver = 0;
    int id;
    SQLiteDatabase db;
    String hora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca__dias);

        calendar = findViewById(R.id.calendarView);
        btAgendar = findViewById(R.id.buttonAgendar);

        ////////////////////////////////////////////////////////
        Intent sal = getIntent();
        Saloes[] saloes;
        saloes = (Saloes[]) sal.getSerializableExtra("saloes");
        if(saloes == null) {
            EditarJson editarJson = new EditarJson();
            saloes = editarJson.getSaloes();
        }
        ////////////////////////////////////////////////////////

        //Traz o id do usuario logado
        SharedPreferences sharedPreferences = getSharedPreferences(
                "prefs", Context.MODE_PRIVATE);
        id = sharedPreferences.getInt("id",0);



        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                dia_selecionado= i2;
                mes_selecionado = i1 + 1;
                ano_selecionado = i;
            }
        });

        Saloes[] finalSaloes = saloes;
        Saloes[] finalSaloes1 = saloes;
        Saloes[] finalSaloes2 = saloes;
        btAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                erro = 1;
                ver = 0;
                // verificação do banco
                db = openOrCreateDatabase(
                        Banco.banco(),
                        Context.MODE_PRIVATE,
                        null);

                // Criar a tabela no banco de dados, caso ela não exista
                db.execSQL(Banco.criaTabelaReserva());

                Date data = new Date();
               Calendar c = Calendar.getInstance();
               c.setTime(data);

               //Recupera a data atual
                Format format = new SimpleDateFormat("d");
                dia_atual = Integer.parseInt(format.format(c.getTime()));
                Format format1 = new SimpleDateFormat("MM");
                mes_atual = Integer.parseInt(format1.format(c.getTime()));
                Format format2 = new SimpleDateFormat("y");
                ano_atual = Integer.parseInt(format2.format(c.getTime()));

                //
                Intent dias = getIntent();
                hora = dias.getStringExtra("Hora");
                pos = dias.getIntExtra("pos",0);
                posProf = dias.getIntExtra("posProf",0);

                //Verifica se a data selecionada é maior que a data atual
                if(ano_selecionado > ano_atual){
                    if(mes_atual == 12 && mes_selecionado == 1){
                        if(dia_selecionado <= dia_atual){
                            erro=0;
                        }
                    }
                } else {
                    if(mes_selecionado >= mes_atual && +(mes_selecionado - mes_atual) <= 1){
                        if(mes_atual < mes_selecionado){
                            if(dia_selecionado <= dia_atual){
                                erro=0;
                            }
                        }
                        if(dia_selecionado >= dia_atual){
                            erro=0;
                        }
                    }
                }

                if(erro==1){
                    Toast.makeText(busca_Dias.this, "Agendamentos só podem ser realizados " +
                                    "com um dia de antecedencia,e no perido maximo de um mẽs, verifique a data.",
                            Toast.LENGTH_SHORT).show();
                }


                Cursor cursor = db.rawQuery("SELECT * FROM " + Banco.tabelaReserva() + " " +
                        "WHERE dia='"+dia_selecionado+"' AND hora='"+ hora+"'",null);
                if(cursor.moveToFirst()){
                    if(dia_selecionado == cursor.getInt(4)) {
                        ver = 1;
                    }
                }

                if(erro == 0) {
                    // verificação do banco
                    db = openOrCreateDatabase(
                            Banco.banco(),
                            Context.MODE_PRIVATE,
                            null);

                    // Criar a tabela no banco de dados, caso ela não exista
                    db.execSQL(Banco.criaTabelaReserva());

                    //Criação de um content values para incluir os dados no banco.
                    ContentValues dados = new ContentValues();

                    dados.put("id",id);
                    dados.put("hora",hora);
                    dados.put("dia",dia_selecionado);
                    dados.put("salao", finalSaloes2[pos].getSalao());
                    dados.put("profissional",finalSaloes[pos].getProfissionais()[posProf].getNome());
                    //inserção no banco
                    if (ver == 0) {
                        // inserir no banco
                        db.insert(
                                Banco.tabelaReserva(),
                                null,
                                dados
                        );
                        Toast.makeText(
                                busca_Dias.this,
                                "Registro inserido com sucesso",
                                Toast.LENGTH_SHORT).show();

                        Intent menu = new Intent(getApplicationContext(), menu_home.class);
                        menu.putExtra("saloes", finalSaloes);
                        startActivity(menu);
                    } else if(ver == 1){
                        Toast.makeText(busca_Dias.this, "Agendamento não realizado, horario não disponível para esse dia.",
                                Toast.LENGTH_SHORT).show();
                    }
                }

                }
        });

    }
}