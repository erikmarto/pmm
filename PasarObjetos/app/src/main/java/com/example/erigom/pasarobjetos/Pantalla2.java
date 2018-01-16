package com.example.erigom.pasarobjetos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.temporal.Temporal;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);


        Bundle miBundleRecoger= getIntent().getExtras();

        Muebles s= (Muebles) miBundleRecoger.getSerializable("CLAVEobjeto");


        TextView nombre= (TextView)findViewById(R.id.nombre);

        nombre.setText(s.getNombre());


        TextView madera= (TextView) findViewById(R.id.madera);

        madera.setText(s.getMadera());


        TextView anchura= (TextView) findViewById(R.id.anchura);

        anchura.setText(String.valueOf(s.getAnchura()));


    }
}
