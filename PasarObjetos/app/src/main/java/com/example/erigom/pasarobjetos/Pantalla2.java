package com.example.erigom.pasarobjetos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.temporal.Temporal;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);


        //TextView elsaludo=(TextView)findViewById(R.id.);


        Bundle miBundleRecoger= getIntent().getExtras();

        Muebles s= (Muebles) miBundleRecoger.getSerializable("CLAVEobjeto");
        //elsaludo.setText("Hola "+s.getNombre());

        TextView nombre= (TextView)findViewById(R.id.nombre);

        nombre.setText(s.getNombre());

        //Toast.makeText(this, "Nombre"+s.getNombre(), Toast.LENGTH_SHORT).show();

        TextView madera= (TextView) findViewById(R.id.madera);

        madera.setText(s.getMadera());

        //Toast.makeText(this, "Creador;"+s.getCreador(), Toast.LENGTH_SHORT).show();

        TextView anchura= (TextView) findViewById(R.id.anchura);

        anchura.setText(String.valueOf(s.getAnchura()));

        //Toast.makeText(this, "Temporada;"+String.valueOf(s.getTemporadas()), Toast.LENGTH_SHORT).show();


        // ImageView imagen = (ImageView) findViewById(R.id.);

        //imagen.setBackground(getDrawable(v.getImagen()));



    }
}
