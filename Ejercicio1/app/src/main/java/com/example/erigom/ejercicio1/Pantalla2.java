package com.example.erigom.ejercicio1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final Button botonRed = (Button) findViewById(R.id.botonRed);
        final Button botonGreen = (Button) findViewById(R.id.botonGreen);
        final Button botonBlue = (Button) findViewById(R.id.botonBlue);
        final Button botonClear = (Button) findViewById(R.id.botonClear);
        final TextView txtColor = (TextView) findViewById(R.id.txtColor);


        botonRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtColor.setBackgroundColor(Color.RED);
            }
        });
        botonGreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtColor.setBackgroundColor(Color.GREEN);
            }
        });
        botonBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtColor.setBackgroundColor(Color.BLUE);
            }
        });
        botonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtColor.setBackgroundColor(Color.WHITE);
            }
        });
    }
}
