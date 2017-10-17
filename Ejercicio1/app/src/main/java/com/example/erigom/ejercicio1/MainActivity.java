package com.example.erigom.ejercicio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button miBotonLiner = (Button) findViewById(R.id.miBtn1);
        final Button miBotonTable = (Button) findViewById(R.id.miBtn2);
        final Button miBotonColors = (Button) findViewById(R.id.miBtn3);
        final Button miBotonRelative = (Button) findViewById(R.id.miBtn4);


        miBotonLiner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, Pantalla1.class);

                startActivity(miIntent);
            }
        });

        miBotonTable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                startActivity(miIntent);
            }
        });

        miBotonColors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, Pantalla3.class);
                startActivity(miIntent);
            }
        });

        miBotonRelative.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, Pantalla4.class);
                startActivity(miIntent);
            }
        });
    }
}