package com.example.erik.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BDUsuarios cliBDh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button entrar= (Button)findViewById(R.id.Entrar);
        Button formulario= (Button)findViewById(R.id.ir_a_registro);
        final EditText verificar_usuario=(EditText)findViewById(R.id.verificar_usuario);
        final EditText verificar_contraseña=(EditText)findViewById(R.id.verificar_contraseña);

        //Abrimos la base de datos en modo escritura
        cliBDh = new BDUsuarios(this, "Usuarios", null, 1);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificar si el usuario y contraseña está en la bd, si es asi, puede entrar dentro

                SQLiteDatabase bd = cliBDh.getWritableDatabase();

                //guardamos los datos introducido en la variables
                String usuario=verificar_usuario.getText().toString();
                String contraseña=verificar_contraseña.getText().toString();

                Cursor fila=bd.rawQuery("SELECT usuario,password FROM Usuarios WHERE usuario='"+usuario+"' and password='"+contraseña+"'",null);

                //para que se coloque en el principio
                if(fila.moveToFirst()) {
                    //capturamos los valores del cursos y lo almacenamos en variable
                    String usu = fila.getString(0);
                    String pass = fila.getString(1);


                    //preguntamos si los datos ingresados son iguales, si coinciden con los almacenados en la bd, puede pasar a la aplicacion
                    if (usuario.equals(usu)&&contraseña.equals(pass)) {

                        Intent adelante= new Intent(MainActivity.this,Aplicacion.class);
                        adelante.putExtra("usuario", usu);
                        startActivity(adelante);


                        //si son iguales entonces vamos a otra ventana
                    }else {
                        String mensaje="Error: usuario o contraseña incorrecta. Vuelva a intentarlo.";
                        Toast.makeText(getApplicationContext(),"completado",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        formulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ir a formulario de registro
                Intent ventana = new Intent(MainActivity.this,Registro.class);
                startActivity(ventana);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.AcercaDe:
                Intent pant1 = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(pant1);
                return true;
            case R.id.Dibujo:
                Intent pant2 = new Intent(MainActivity.this, Dibujo.class);
                startActivity(pant2);
                return true;
            case R.id.Noticias:
                Intent pant3 = new Intent(MainActivity.this, Noticias.class);
                startActivity(pant3);
                return true;
            case R.id.Coordenadas:
                Intent pant4 = new Intent(MainActivity.this, Coordenadas.class);
                startActivity(pant4);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
