package com.example.erik.proyectofinal;

import java.io.Serializable;

public class Accesorios implements Serializable {

    String nombre, estilo, clase;
    Double precio;

    public Accesorios(String nom, String est, String clas, Double pre) {
        this.nombre = nom;
        this.estilo = est;
        this.clase = clas;
        this.precio = pre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Accesorios{" +
                "titulo='" + nombre + '\'' +
                ", estilo='" + estilo + '\'' +
                ", clase='" + clase + '\'' +
                ", precio=" + precio +
                '}';
    }
}
