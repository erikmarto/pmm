package com.example.erigom.proyectoexamen;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String strMessageCheck = "";
    String strMessageRadio = "";
    Spinner miSpinner;
    CheckBox regalo;
    CheckBox personalizada;
    private RadioButton RNormal;
    private RadioButton RUrgente;


    final static String zonas[] = {"Zona A: Asia y Oceanía: 30 €","Zona B: América y África, 20 €","Zona C: Europa 10 €"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = (Spinner) findViewById(R.id.spinner1);


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, zonas);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        miSpinner.setAdapter(adaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "La pantalla seleccionada es: " + zonas[position];
                showToast(mensaje);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //EditText
        final Spinner textoSpinner = (Spinner) findViewById(R.id.spinner1);
        final EditText miTexto= (EditText) findViewById(R.id.editText);

        //borrar texto edittext
        miTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miTexto.setText("");
            }
        });


        RNormal = (RadioButton)findViewById(R.id.radioButton1);
        RUrgente = (RadioButton)findViewById(R.id.radioButton2);

        final Button btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);

                Bundle miBundle = new Bundle();

                String mensajezona = "ZONA: " + textoSpinner.getSelectedItem();
                miBundle.putString("ZONA", mensajezona);

                String mensajePeso = "PESO: " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePeso + "kg");

                getTarifa(v);
                String mensajeTarifa = "TARIFA: ";
                miBundle.putString("TARIFA", mensajeTarifa + strMessageRadio);

                getDetalle(v);
                String mensajeTarjeta ="TARJETA: ";
                miBundle.putString("DETALLES", mensajeTarjeta + strMessageCheck);
                miIntent.putExtras(miBundle);


                startActivity(miIntent);
            }
        });
        detalles();
    }
    public  void detalles() {
        regalo = (CheckBox) findViewById(R.id.checkBox1);
        personalizada = (CheckBox) findViewById(R.id.checkBox2);
    }

    public void getDetalle(View v){
        strMessageCheck = "";
        if (regalo.isChecked()) {
            strMessageCheck = "Caja Regalo";
        }
        if (personalizada.isChecked()) {
            strMessageCheck = "Tarjeta Dedicada";
        }
        if (personalizada.isChecked() && regalo.isChecked()) {
            strMessageCheck = "Caja Regalo y Tarjeta Dedicada";
        }
        else{
            strMessageCheck = "Ninguna";
        }
    }

    public void getTarifa(View v) {
        final RadioGroup selectgroup = (RadioGroup) findViewById(R.id.radioGroup);
        selectgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (selectgroup.getCheckedRadioButtonId() == R.id.radioButton1) {
                    strMessageRadio = "Tarifa Normal";
                }
                if (selectgroup.getCheckedRadioButtonId() == R.id.radioButton2) {
                    strMessageRadio = "Tarifa Urgente";
                }
            }
        });
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}