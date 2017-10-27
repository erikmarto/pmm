package com.example.erigom.pasardatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEnviar;
    private EditText ediNombre,ediTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar=(Button)findViewById(R.id.btnEnviar);
        ediNombre = (EditText) findViewById( R.id.edi_nombre );
        ediTelefono = (EditText) findViewById( R.id.edi_telefono );

        btnEnviar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent explicit_intent;


        explicit_intent = new Intent(this,Pantalla2.class);
        String auxEdiNombre=ediNombre.getText().toString();
        String auxEdiTelefono=ediTelefono.getText().toString();

        explicit_intent.putExtra("nombre",auxEdiNombre);
        explicit_intent.putExtra("telefono",auxEdiTelefono);

        startActivity(explicit_intent);
    }
}
