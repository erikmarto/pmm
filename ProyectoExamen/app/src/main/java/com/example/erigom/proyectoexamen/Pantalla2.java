package com.example.erigom.proyectoexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    Spinner miSpinner2;
    final static String menu2[] = {"Acerca de ", "Pantalla dibujo "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        //Menu con Acerca de y la Pantalla del dibujo
        miSpinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, menu2);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpinner2.setAdapter(adaptador);


        miSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "La pantalla seleccionada es: " + menu2[position];
                showToast(mensaje);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Texto del editText
        final TextView peso = (TextView) findViewById(R.id.peso);
        final TextView zona = (TextView) findViewById(R.id.zona);
        final TextView decoracion = (TextView) findViewById(R.id.decoracion);
        final TextView tarifa = (TextView) findViewById(R.id.tarifa);

        Bundle bundle = getIntent().getExtras();
        peso.setText(bundle.getString("TEXTO"));

        Bundle bundle1 = getIntent().getExtras();
        zona.setText(bundle1.getString("ZONA"));

        Bundle bundle2 = getIntent().getExtras();
        tarifa.setText(bundle2.getString("TARIFA"));

        Bundle bundle3 = getIntent().getExtras();
        decoracion.setText(bundle3.getString("DETALLES"));

    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
