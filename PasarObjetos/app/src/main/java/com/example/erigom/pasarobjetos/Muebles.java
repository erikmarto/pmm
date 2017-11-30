package com.example.erigom.pasarobjetos;

import java.io.Serializable;


public class Muebles implements Serializable {

    private String Nombre;
    private String Madera;
    private int Anchura;

    public Muebles (String nombre, String madera,int anchura){

        this.Nombre = nombre;
        this.Madera = madera;
        this.Anchura = anchura;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMadera() {
        return Madera;
    }

    public void setMadera(String madera) {
        Madera = madera;
    }

    public int getAnchura() {
        return Anchura;
    }

    public void setAnchura(int anchura) {
        Anchura = anchura;
    }
}
