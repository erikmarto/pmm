package com.example.erigom.myapplication;

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
        final Button miBotonRelative = (Button) findViewById(R.id.miBtn3);
        final Button miBotonGrid = (Button) findViewById(R.id.miBtn4);
        final Button miBotonRadio = (Button) findViewById(R.id.miBtn5);
        final Button miBotonTipos = (Button) findViewById(R.id.miBtn6);


        miBotonLiner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, PantallaLiner.class);

                startActivity(miIntent);
            }
        });

        miBotonTable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, PantallaTable.class);
                startActivity(miIntent);
            }
        });

        miBotonRelative.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, PantallaRelative.class);
                startActivity(miIntent);
            }
        });

        miBotonGrid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, PantallaCheck.class);
                startActivity(miIntent);
            }
        });

        miBotonRadio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, PantallaRadio.class);
                startActivity(miIntent);
            }
        });

        miBotonTipos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, PantallaTipos.class);
                startActivity(miIntent);
            }
        });
    }
}
