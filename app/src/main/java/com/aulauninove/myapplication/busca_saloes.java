package com.aulauninove.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aulauninove.myapplication.pojo.Saloes;

public class busca_saloes extends AppCompatActivity {

    ListView listView;
    int images[] = {R.drawable.logobelo,R.drawable.logounicortes,R.drawable.cadastroimag,R.drawable.salaoimag};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_saloes);
        ////////////////////////////////////////////////////////
        Intent sal = getIntent();
        Saloes[] saloes;
        saloes = (Saloes[]) sal.getSerializableExtra("saloes");
        if(saloes == null) {
            EditarJson editarJson = new EditarJson();
            saloes = editarJson.getSaloes();
        }
        ////////////////////////////////////////////////////////


        String mtitle[] = {saloes[0].getSalao(), saloes[1].getSalao(), saloes[2].getSalao(), saloes[3].getSalao()};
        String mDescripition[] = {saloes[0].getEndereco(), saloes[1].getEndereco(), saloes[2].getEndereco(), saloes[3].getEndereco()};

        ////////////////////////////////////////////////////////
        listView = findViewById(R.id.list_view);

        MyAdapter adapter = new MyAdapter(this, mtitle, mDescripition, images);

        listView.setAdapter(adapter);

        Saloes[] finalSaloes = saloes;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent profissionais = new Intent(getApplicationContext(),Busca_prof.class);
                    profissionais.putExtra("pos",position);
                    profissionais.putExtra("posProf", 0);
                    profissionais.putExtra("saloes", finalSaloes);
                    startActivity(profissionais);
                }
                if(position == 1){
                    Intent profissionais = new Intent(getApplicationContext(),Busca_prof.class);
                    profissionais.putExtra("pos",position);
                    profissionais.putExtra("posProf", 1);
                    profissionais.putExtra("saloes", finalSaloes);
                    startActivity(profissionais);
                }
                if(position == 2){
                    Intent profissionais = new Intent(getApplicationContext(),Busca_prof.class);
                    profissionais.putExtra("pos",position);
                    profissionais.putExtra("posProf", 2);
                    profissionais.putExtra("saloes", finalSaloes);
                    startActivity(profissionais);
                }
                if(position == 3){
                    Intent profissionais = new Intent(getApplicationContext(),Busca_prof.class);
                    profissionais.putExtra("pos",position);
                    profissionais.putExtra("posProf", 3);
                    profissionais.putExtra("saloes", finalSaloes);
                    startActivity(profissionais);
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