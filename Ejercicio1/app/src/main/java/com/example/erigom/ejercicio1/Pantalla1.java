package com.example.erigom.ejercicio1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class Pantalla1 extends AppCompatActivity {

    RadioButton radioR;
    RadioButton radioG;
    RadioButton radioB;
    Button btnSet;
    Button btnCan;
    TextView txtColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        initialUISetup();
    }

    public void initialUISetup() {
        radioR = (RadioButton) findViewById(R.id.radio1);
        radioG = (RadioButton) findViewById(R.id.radio2);
        radioB = (RadioButton) findViewById(R.id.radio3);
        btnSet = (Button) findViewById(R.id.button1);
        btnCan = (Button) findViewById(R.id.button2);
        txtColor = (TextView) findViewById(R.id.txtcolor);

        btnSet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getColorClick(v);
            }
        });
        btnCan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtColor.setBackgroundColor(Color.WHITE);
            }
        });
    }

    public void getColorClick(View v) {
        if (radioR.isChecked()) {
            txtColor.setBackgroundColor(Color.RED);
        }
        if (radioG.isChecked()) {
            txtColor.setBackgroundColor(Color.GREEN);
        }
        if (radioB.isChecked()) {
            txtColor.setBackgroundColor(Color.BLUE);
        }
    }
}