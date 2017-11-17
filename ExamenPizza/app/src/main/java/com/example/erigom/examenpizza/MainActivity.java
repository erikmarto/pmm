package com.example.erigom.examenpizza;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] pizza= {"Margarita - 12€","Tres Quesos - 15€","Barbacoa - 18€","Especial - 21€"};
    private String[] descripcion = {"jamon/tomate","queso1/queso2","carne/tomate","de la casa"};
    private double[] precio = {12,15,18};
    private int[] imagenes = {R.drawable.pizza1, R.drawable.pizza2,R.drawable.pizza3};
    private int imagenSeleccionada;
    private double precioSeleccionado;

    private Spinner mySpinner;
    private CheckBox chkbox1,chkbox2,chkbox3;
    private RadioButton radb1,radb2;
    private EditText txt1;
    private Button botonCalcular;
    private TextView t1;


    public boolean onCreateOptionsMenu ( Menu menu){
        getMenuInflater().inflate(R.menu.menu_extra, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                Intent dibujo = new Intent(MainActivity.this, Imagen.class);
                startActivity(dibujo);
                return true;
            case R.id.MnuOpc2:
                Intent acerca = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(acerca);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySpinner = (Spinner)findViewById(R.id.spinner);
        chkbox1 = (CheckBox)findViewById(R.id.checkBox1);
        chkbox2 = (CheckBox)findViewById(R.id.checkBox2);
        chkbox3 = (CheckBox)findViewById(R.id.checkBox3);
        radb1 = (RadioButton)findViewById(R.id.radioButton1);
        radb2 = (RadioButton)findViewById(R.id.radioButton2);
        txt1 = (EditText)findViewById(R.id.editText);
        botonCalcular = (Button)findViewById(R.id.button);
        t1 = (TextView)findViewById(R.id.textView2);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, pizza);
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(miAdaptador);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String mensaje = "";
                mensaje = "Has seleccionado " + pizza[pos] +" con descripcion "+descripcion[pos]+ " con el precio " + precio[pos];
                showToast(mensaje);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        botonCalcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                double total = 0 ;
                double total1 = 0;
                String box = " ";
                String sele = " ";
                String n = txt1.getText().toString();
                double num = Double.parseDouble(n);
                String seleccion = mySpinner.getSelectedItem().toString();
                if(seleccion.equals("Margarita - 12€")){
                    total1 += 12;
                    imagenSeleccionada = imagenes[0];
                    precioSeleccionado = precio[0];
                }
                if(seleccion.equals("Tres Quesos - 15€")){
                    total1 += 15;
                    imagenSeleccionada = imagenes[1];
                    precioSeleccionado = precio[1];
                }
                if(seleccion.equals("Barbacoa - 18€")){
                    total1 += 18;
                    imagenSeleccionada = imagenes[2];
                    precioSeleccionado = precio[2];
                }
                if(seleccion.equals("Barbacoa - 21€")){
                    total1 += 21;
                    imagenSeleccionada = imagenes[3];
                    precioSeleccionado = precio[3];
                }

                if(chkbox1.isChecked() == true){
                    total1 += 1;
                    sele += chkbox1.getText()+" ";

                }
                if(chkbox2.isChecked() == true){
                    total1 += 1;
                    sele += chkbox2.getText()+" ";
                }
                if(chkbox3.isChecked() == true){
                    total1+= 1;
                    sele += chkbox3.getText()+" ";
                }
                if(num >= 0){
                    total1 = total1 * num;
                }
                if(radb1.isChecked() == true){
                    total1 += 0;
                    box = radb1.getText()+" ";
                }
                if(radb2.isChecked() == true){
                    total = total1 * 0.1 ;
                    total1 += total;
                    box = radb2.getText()+" ";
                }
                String mensaje = "Total: "+total1+" euros.";
                t1.setText(mensaje);

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                String pizzaSeleccion = "Pizza "+seleccion;
                String unidad = "Unidades :"+num;
                String mensajeEnvio = "Envio: "+box;
                String extra = "Extra: "+sele;
                String precioBase = "PRECIO BASE: "+precioSeleccionado;
                String precioFinal = "COSTE FINAL : "+total1;
                miBundle.putString("PIZZA",pizzaSeleccion);
                miBundle.putString("UNIDAD", unidad);
                miBundle.putString("SELECCION",mensajeEnvio);
                miBundle.putString("TEXTO", precioFinal);
                miBundle.putString("PRECIO",precioBase);
                miBundle.putString("EXTRA",extra);
                miBundle.putInt("IMAGEN",imagenSeleccionada);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }}
        );

    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
