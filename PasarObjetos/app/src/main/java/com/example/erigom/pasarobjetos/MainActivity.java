package com.example.erigom.pasarobjetos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner miSpinner;
    private Muebles [] datos = new Muebles []{
            new Muebles("Armario","madera de arce" ,2),
            new Muebles("Mesa", "madera de pino",8),
            new Muebles("Silla", "madera de roble",4),
            new Muebles("Sofa", "muy comodo",7),
            new Muebles("Escritorio", "grande",5),
            new Muebles("Lampara", "muy bonita",6)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorMuebles miAdaptador = new AdaptadorMuebles(this);
        miSpinner.setAdapter(miAdaptador);


        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                // String mensaje ="Nombre:"+ datos[i].getNombre() +" Apellidos: "+ datos[i].getApellidos();
                // Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();


                Muebles muebles= datos[i];

                Bundle miBundle = new Bundle();
                miBundle.putSerializable("CLAVEobjeto",muebles);

                Intent intent = new Intent(MainActivity.this,Pantalla2.class);
                intent.putExtras(miBundle);

                startActivity(intent);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    //    public void showToast(String text) {
//
//        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
//    }
    static class  ViewHolder{

        TextView Nombre;
        TextView Madera;
        TextView Anchura;
        //ImageView foto;
    }

    class AdaptadorMuebles extends ArrayAdapter<Muebles> {
        public Activity miActividad;

        public AdaptadorMuebles(Activity laActividad) {
            super(laActividad, R.layout.listitem_muebles, datos);
            this.miActividad = laActividad;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            ViewHolder holder;
            View item = convertView;

            if (item == null) {
                LayoutInflater inflater = miActividad.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_muebles, null);


                holder = new ViewHolder();
                holder.Nombre = (TextView) item.findViewById(R.id.nombre);
                holder.Madera= (TextView) item.findViewById(R.id.madera);
                holder.Anchura = (TextView) item.findViewById(R.id.anchura);
                // holder.foto =(ImageView) item.findViewById(R.id.ivImagen);

                item.setTag(holder);

            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.Nombre.setText(datos[i].getNombre());
            holder.Madera.setText(datos[i].getMadera());
            holder.Anchura.setText(String.valueOf(datos[i].getAnchura()));
            //holder.foto.setBackground(getDrawable(datos[i].getImagen()));


            TextView IblNombre = (TextView) item.findViewById(R.id.nombre);
            IblNombre.setText(datos[i].getNombre());

            TextView IblCreador = (TextView) item.findViewById(R.id.madera);
            IblCreador.setText(datos[i].getMadera());

            TextView IblTemporada = (TextView) item.findViewById(R.id.anchura);
            IblTemporada.setText(String.valueOf(datos[i].getAnchura()));


            //ImageView imagen = (ImageView) item.findViewById(R.id.ivImagen);
            //imagen.setBackground(getDrawable(personas[i].getImagen()));

            return item;


        }

    }



}
