package com.example.erik.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    String usuarios = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT,usuario TEXT, password TEXT)";
    String accesorios = "CREATE TABLE Accesorios (Nombre TEXT, Estilo TEXT, Clase TEXT, Precio DOUBLE)";
    String ventas = "CREATE TABLE Ventas (usuarios TEXT, Nombre TEXT, Estilo TEXT, Clase TEXT, Precio DOUBLE, Plataforma TEXT, " +
            "Forma_pago TEXT, FOREIGN KEY (usuarios) REFERENCES Usuarios (id))";


    public DataBaseHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version) {
        super(contexto, nombre, almacen, version);
    }

    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(usuarios);
        bd.execSQL(accesorios);
        bd.execSQL(ventas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        //Eliminamos la version anterior de la tabla
        bd.execSQL("DROP TABLE IF EXISTS Usuarios");
        bd.execSQL(usuarios);

    }

}
