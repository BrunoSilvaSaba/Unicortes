package com.aulauninove.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.aulauninove.myapplication.pojo.Profissionais;
import com.aulauninove.myapplication.pojo.Saloes;

import java.util.ArrayList;
import java.util.List;

public class Busca_prof extends AppCompatActivity {

    //Declaração de variaveis
    ListView listViewprof;
    ArrayList<Profissionais> profissionaisArrayList = new ArrayList<>();
    Integer pos, i;
    Saloes[] saloes;
    Profissionais[] profissionais;
    int images[] = {R.drawable.logobelo,R.drawable.logobelo,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_prof);

        Intent profissionais = getIntent();
        pos = profissionais.getIntExtra("pos",0);

        ////////////////////////////////////////////////////////
        Intent sal = getIntent();
        Saloes[] saloes;
        saloes = (Saloes[]) sal.getSerializableExtra("saloes");
        if(saloes == null) {
            EditarJson editarJson = new EditarJson();
            saloes = editarJson.getSaloes();
        }
        ////////////////////////////////////////////////////////


        String mtitle[] = {saloes[pos].getProfissionais()[0].getNome(), saloes[pos].getProfissionais()[1].getNome(),
                saloes[pos].getProfissionais()[2].getNome(), saloes[pos].getProfissionais()[3].getNome()};
        String mDescripition[] = {saloes[pos].getProfissionais()[0].getAllServicos(saloes[pos].getProfissionais()[0].getServicos()),
                saloes[pos].getProfissionais()[1].getAllServicos(saloes[pos].getProfissionais()[1].getServicos()),
                saloes[pos].getProfissionais()[2].getAllServicos(saloes[pos].getProfissionais()[2].getServicos()),
                saloes[pos].getProfissionais()[3].getAllServicos(saloes[pos].getProfissionais()[3].getServicos())};

        ////////////////////////////////////////////////////////
        listViewprof = findViewById(R.id.list_view_busca_prof);

        MyAdapter adapter = new MyAdapter(this, mtitle, mDescripition, images);

        listViewprof.setAdapter(adapter);

        Saloes[] finalSaloes = saloes;
        listViewprof.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              if(i == 0){
                  Intent horarios = new Intent(getApplicationContext(),busca_horarios.class);
                  horarios.putExtra("pos",pos);
                  horarios.putExtra("posProf",0);
                  horarios.putExtra("saloes", finalSaloes);
                  startActivity(horarios);
              }
              if(i == 1){
                  Intent horarios = new Intent(getApplicationContext(),busca_horarios.class);
                  horarios.putExtra("pos",pos);
                  horarios.putExtra("posProf",1);
                  horarios.putExtra("saloes", finalSaloes);
                  startActivity(horarios);
              }
              if(i == 2){
                  Intent horarios = new Intent(getApplicationContext(),busca_horarios.class);
                  horarios.putExtra("pos",pos);
                  horarios.putExtra("posProf",2);
                  horarios.putExtra("saloes", finalSaloes);
                  startActivity(horarios);
              }
              if(i == 3){
                  Intent horarios = new Intent(getApplicationContext(),busca_horarios.class);
                  horarios.putExtra("pos",pos);
                  horarios.putExtra("posProf",3);
                  horarios.putExtra("saloes", finalSaloes);
                  startActivity(horarios);
              }
          }
      });

        }
    private class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String descripition[], int imgs[]){
            super(c, R.layout.row_busca, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = descripition;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row_busca, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }

}