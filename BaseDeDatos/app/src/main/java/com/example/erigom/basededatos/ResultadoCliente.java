package com.example.erigom.basededatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoCliente extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cliente);

        TextView nombre = findViewById(R.id.nombre);
        TextView telefono = findViewById(R.id.telefono);

        nombre.setText("Nombre: " + nombre.getText());
        telefono.setText("Telefono: " + telefono.getText());
    }
}
