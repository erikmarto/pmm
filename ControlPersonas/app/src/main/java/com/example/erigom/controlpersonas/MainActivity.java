package com.example.erigom.controlpersonas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity {


    private Titular[] datos = new Titular[]{
            new Titular("Datos ", " Icono1", R.drawable.servicio1),
            new Titular("Servicios ", " Icono2", R.drawable.servicio2),
            new Titular("Ayuda al Cliente ", " Icono3", R.drawable.servicio3)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView IstOpciones = (ListView) findViewById(R.id.LstOpciones);
        IstOpciones.setAdapter(adaptador);

        IstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        /*IstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {

                Intent miIntent1 = new Intent(MainActivity.this, Pantalla2.class);
                startActivity(miIntent1);
            }
        });*/
    }

    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
        ImageView imagen;
    }

    class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;

            if (item == null) {

                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_titular, null);

                holder = new ViewHolder();
                holder.titulo = (TextView) item.findViewById(R.id.tvTitulo);
                holder.subtitulo = (TextView) item.findViewById(R.id.tvSubtitulo);
                holder.imagen = (ImageView) item.findViewById(R.id.ivImagen);
                item.setTag(holder);
            }
            else { holder = (ViewHolder) item.getTag();
            }

            holder.titulo.setText(datos[i].getTitulo());
            holder.subtitulo.setText(datos[i].getSubtitulo());
            holder.imagen.setBackground(getDrawable(datos[i].getImagen()));

            return (item);

        }
    }
}
