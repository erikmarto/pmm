package com.example.erik.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DataBaseHelper acce_DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button entrar = (Button) findViewById(R.id.Entrar);
        Button formulario = (Button) findViewById(R.id.ir_a_registro);
        final EditText verificar_usuario = (EditText) findViewById(R.id.verificar_usuario);
        final EditText verificar_contraseña = (EditText) findViewById(R.id.verificar_contraseña);

        //Abrimos la base de datos en modo escritura
        acce_DB = new DataBaseHelper(this, "Usuarios", null, 1);
        Toast.makeText(getApplicationContext(), "Bienvenido, introducza su usuario", Toast.LENGTH_SHORT).show();
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase bd = acce_DB.getWritableDatabase();

                String usuario = verificar_usuario.getText().toString();
                String contraseña = verificar_contraseña.getText().toString();

                Cursor fila = bd.rawQuery("SELECT usuario,password FROM Usuarios WHERE usuario='" + usuario + "' and password='" + contraseña + "'", null);

                if (fila.moveToFirst()) {
                    String usu = fila.getString(0);
                    String pass = fila.getString(1);

                    if (usuario.equals(usu) && contraseña.equals(pass)) {

                        Intent adelante = new Intent(MainActivity.this, Aplicacion.class);
                        adelante.putExtra("usuario", usu);
                        startActivity(adelante);
                        Toast.makeText(getApplicationContext(), "Completada la conexión", Toast.LENGTH_SHORT).show();
                    } else {
                        String mensaje = "No ha introducido bien el usuario";
                        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        formulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(MainActivity.this, Registro.class);
                startActivity(registro);
            }
        });
    }
}
