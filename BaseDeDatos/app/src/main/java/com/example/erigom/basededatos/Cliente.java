package com.example.erigom.basededatos;


import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre, telf;


    public Cliente(String nom, String telefono){
        nombre=nom;
        telf=telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", telf='" + telf + '\'' +
                '}';
    }
}