package com.example.erik.proyectoexamen_mejorado;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    TextView nom;
    private Pizza pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle bundle = getIntent().getExtras();
        TextView extras = (TextView) findViewById(R.id.TVextra);
        TextView Envio = (TextView) findViewById(R.id.TVEnvio);
        TextView cantidad = (TextView) findViewById(R.id.TVunidades);
        TextView coste = (TextView) findViewById(R.id.TVcoste);
        TextView preciobase = (TextView) findViewById(R.id.TVprecio);
        ImageView img = (ImageView) findViewById(R.id.imageView);
        nom = (TextView) findViewById(R.id.TVpizza);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        final DigitalClock dc = (DigitalClock) findViewById(R.id.reloj);
        pizza = (Pizza) bundle.getSerializable("PIZZA");
        String a = Integer.toString(pizza.getPrecio());
        nom.setText(pizza.getNombre());
        preciobase.setText(a);
        extras.setText(bundle.getString("EXTRAS"));
        cantidad.setText(bundle.getString("CANTIDAD"));
        Envio.setText(bundle.getString("ENVIO"));
        coste.setText(bundle.getString("TOTAL"));
        img.setImageResource(pizza.getFoto());

        checkBox.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    dc.setVisibility(1);
                }
            }
        });


    }
}
