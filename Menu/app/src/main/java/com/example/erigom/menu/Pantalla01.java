package com.example.erigom.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pantalla01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla01);
        TextView lblMensaje =(TextView) findViewById(R.id.lblMensaje);
        lblMensaje.setText ("CIRCULO!");
    }
}
