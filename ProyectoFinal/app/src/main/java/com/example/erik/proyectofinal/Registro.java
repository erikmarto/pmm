package com.example.erik.proyectofinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private DataBaseHelper acce_DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Button registrarse = (Button) findViewById(R.id.registro);
        Button volver_login = (Button) findViewById(R.id.volver_login);
        final EditText registro_usuario = (EditText) findViewById(R.id.registro_usuario);
        final EditText registro_contraseña = (EditText) findViewById(R.id.registro_contraseña);

        //Abrimos la base de datos en modo escritura
        acce_DB = new DataBaseHelper(this, "Usuarios", null, 1);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //se guarda los datos del registro en la base de datos de USUARIOS  Y CONTRASEÑAS

                //Obtenemos referencia a la base de datos para poder modificarla.
                SQLiteDatabase bd = acce_DB.getWritableDatabase();
                bd.execSQL("INSERT INTO Usuarios (usuario, password) VALUES ('" + registro_usuario.getText().toString() + "','" + registro_contraseña.getText().toString() + "')");
                bd.close();
                Intent main = new Intent(Registro.this, MainActivity.class);
                startActivity(main);
                Toast.makeText(getApplicationContext(), "Usuario Registrado", Toast.LENGTH_SHORT).show();
            }
        });

        volver_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Registro.this, MainActivity.class);
                startActivity(volver);
            }
        });
    }
}
