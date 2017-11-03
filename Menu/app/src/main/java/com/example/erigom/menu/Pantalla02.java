package com.example.erigom.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Pantalla02 extends AppCompatActivity {
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla02);
        TextView lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        lblMensaje.setText("CUADRADO!");

        textview = (TextView) findViewById(R.id.lblContext);
        registerForContextMenu(textview);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    public boolean onContextItemSelected(MenuItem itemMnuContex) {
        TextView lblMensaje = (TextView) findViewById(R.id.lblContext);
        switch (itemMnuContex.getItemId()) {
            case R.id.CtxLblOpc1:
                lblMensaje.setText("Etiqueta: Opcion 1 pulsada!");
                return true;
            case R.id.CtxLblOpc2:
                lblMensaje.setText("Etiqueta: Opcion 2 pulsada!");
                return true;
            default:
                return super.onContextItemSelected(itemMnuContex);
        }
    }
}
