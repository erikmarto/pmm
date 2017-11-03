package com.example.erigom.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        TextView lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje.setText("Inicio pulsado!");
                return true;
            case R.id.MnuOpc2:
                lblMensaje.setText("Desarrollo pulsado!");
                return true;
            case R.id.MnuOpc3:
                lblMensaje.setText("Interfaz pulsada!");
                return true;
            case R.id.SubMnuOpc1:
                Intent miIntent1 = new Intent(MainActivity.this, Pantalla01.class);
                startActivity(miIntent1);
                return true;
            case R.id.SubMnuOpc2:
                Intent miIntent2 = new Intent(MainActivity.this, Pantalla02.class);
                startActivity(miIntent2);
                return true;
            case R.id.SubMnuOpc3:
                Intent miIntent3 = new Intent(MainActivity.this, Pantalla03.class);
                startActivity(miIntent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

