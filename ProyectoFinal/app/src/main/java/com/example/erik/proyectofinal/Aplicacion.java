package com.example.erik.proyectofinal;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Aplicacion extends AppCompatActivity implements FragmentoDinamico.OnFragmentInteractionListener {
    public ArrayList<Accesorios> accesorios = new ArrayList<Accesorios>();
    private Accesorios[] listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion);

        final Button boton_comprar = (Button) findViewById(R.id.boton_comprar);
        DataBaseHelper acce_DB = new DataBaseHelper(this, "Usuarios", null, 1);
        SQLiteDatabase bd = acce_DB.getWritableDatabase();

        bd.execSQL("INSERT INTO Accesorios (Nombre, Estilo, Clase, Precio) VALUES ('Cinta Elastica','Pilates','rest.10-30','15.99')");
        bd.execSQL("INSERT INTO Accesorios (Nombre, Estilo, Clase, Precio) VALUES ('Cuerda/Salto','Boxeo','ligera,alt.vel','20.99')");
        bd.execSQL("INSERT INTO Accesorios (Nombre, Estilo, Clase, Precio) VALUES ('Muñequeras','Crossfit','anti.lesion','12.99')");
        bd.execSQL("INSERT INTO Accesorios (Nombre, Estilo, Clase, Precio) VALUES ('Auriculares Bluetooth','Runner','comodos,ligeros','29.99')");
        bd.execSQL("INSERT INTO Accesorios (Nombre, Estilo, Clase, Precio) VALUES ('Guantes','Alterofilia','agarre,cont.peso','10.99')");
        bd.execSQL("INSERT INTO Accesorios (Nombre, Estilo, Clase, Precio) VALUES ('Kangoo Jumps','Cardio','estables','39.99')");



        String[] campos = new String[]{"Nombre", "Estilo", "Clase", "Precio"};
        Cursor c = bd.query("Accesorios", campos, null, null, null, null, null);
        listado = new Accesorios[c.getCount()];
        int i = 0;
        //Nos aseguramos de que exista al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String nombre = c.getString(0);
                String estilo = c.getString(1);
                String clase = c.getString(2);
                Double precio = c.getDouble(3);

                listado[i] = new Accesorios(nombre, estilo, clase, precio);

                i++;

            } while (c.moveToNext());
        }

        AdaptadorAccesorios adaptador = new AdaptadorAccesorios(this);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Nombre: " + listado[position].getNombre() + ", Estilo: " + listado[position].getEstilo() + ", Clase: " + listado[position].getClase() + ", Precio: " + listado[position].getPrecio();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bd.close();

        boton_comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle objetos = new Bundle();

                Accesorios datos = new Accesorios(listado[spinner.getSelectedItemPosition()].getNombre(),
                        listado[spinner.getSelectedItemPosition()].getEstilo(),
                        listado[spinner.getSelectedItemPosition()].getClase(),
                        listado[spinner.getSelectedItemPosition()].getPrecio());

                objetos.putSerializable("informacion", datos);


                CheckBox regalo = (CheckBox) findViewById(R.id.caja_regalo);
                CheckBox internet = (CheckBox) findViewById(R.id.caja_internet);
                CheckBox recoger = (CheckBox) findViewById(R.id.caja_recoger);
                RadioButton efectivo = (RadioButton) findViewById(R.id.pago_efectivo);
                RadioButton tarjeta = (RadioButton) findViewById(R.id.pago_tarjeta);
                RadioGroup grupo = (RadioGroup) findViewById(R.id.radiogroup);

                boolean selected1 = false;
                boolean selected2 = false;
                boolean selected3 = false;
                if (regalo.isChecked()) {
                    selected1 = true;
                }
                objetos.putBoolean("boolean1", selected1);
                objetos.putString("caja_regalo", regalo.getText().toString());

                if (internet.isChecked()) {
                    selected2 = true;
                }
                objetos.putBoolean("boolean2", selected2);
                objetos.putString("caja_internet", internet.getText().toString());

                if (recoger.isChecked()) {
                    selected3 = true;
                }
                objetos.putBoolean("boolean3", selected3);
                objetos.putString("caja_recoger", recoger.getText().toString());

                if (grupo.getCheckedRadioButtonId() == R.id.pago_efectivo) {
                    objetos.putString("grupo", efectivo.getText().toString());
                } else {
                    objetos.putString("grupo", tarjeta.getText().toString());
                }

                String usu = getIntent().getStringExtra("usuario");
                objetos.putSerializable("usuario", usu);


                //obtener la instancia del administrador de fragmentos
                FragmentManager fragmentmanager = getFragmentManager();

                //crear la transaccion
                FragmentTransaction transaction = fragmentmanager.beginTransaction();

                //crear un nuevo ojbeto de nuestro fragment y añadirlo
                FragmentoDinamico fragment = new FragmentoDinamico();
                fragment.setArguments(objetos);

                transaction.add(R.id.activity_aplicacion, fragment);

                //confirmar el cambio
                transaction.commit();
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
                Intent pant1 = new Intent(Aplicacion.this, AcercaDe.class);
                startActivity(pant1);
                return true;
            case R.id.Dibujo:
                Intent pant2 = new Intent(Aplicacion.this, Dibujo.class);
                startActivity(pant2);
                return true;
            case R.id.Noticias:
                Intent pant3 = new Intent(Aplicacion.this, Noticias.class);
                startActivity(pant3);
                return true;
            case R.id.Coordenadas:
                Intent pant4 = new Intent(Aplicacion.this, Coordenadas.class);
                startActivity(pant4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class AdaptadorAccesorios extends ArrayAdapter {

        Activity context;

        AdaptadorAccesorios(Activity context) {

            super(context, R.layout.accesorios, listado);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.accesorios, null);

            TextView nom = (TextView) item.findViewById(R.id.accesorio_nombre);
            nom.setText(listado[i].getNombre());

            TextView est = (TextView) item.findViewById(R.id.accesorio_estilo);
            est.setText(listado[i].getEstilo());

            TextView clas = (TextView) item.findViewById(R.id.accesorio_clase);
            clas.setText(listado[i].getClase());

            TextView pre = (TextView) item.findViewById(R.id.accesorio_precio);
            pre.setText(String.valueOf(listado[i].getPrecio()));

            return (item);
        }
    }
}
