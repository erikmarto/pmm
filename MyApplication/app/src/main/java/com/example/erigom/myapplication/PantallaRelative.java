package com.example.erigom.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaRelative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_relative);

        final Button botonPrueba = (Button) findViewById(R.id.botonPrueba);
        final TextView etiquetaPrueba = (TextView) findViewById(R.id.etiquetaPrueba);


        botonPrueba.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                etiquetaPrueba.setText("Hola Relative");
            }
        });
        final Button botonVolver = (Button) findViewById(R.id.botonVolver);

        botonVolver.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent miIntent2 = new Intent(PantallaRelative.this, MainActivity.class);

                startActivity(miIntent2);
            }
        });
    }
}
