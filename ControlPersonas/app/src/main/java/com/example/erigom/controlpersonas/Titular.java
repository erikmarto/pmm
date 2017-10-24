package com.example.erigom.controlpersonas;


public class Titular {
    private String titulo;
    private String subtitulo;
    private int imagen;

    public Titular(String tit, String sub, int img){
        this.titulo = tit;
        this.subtitulo = sub;
        this.imagen = img;
    }

    public int getImagen(){return imagen;}
    public String getTitulo(){return titulo;}
    public String getSubtitulo() {return subtitulo;}

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
    public void setTitular(String titulo) { this.titulo = titulo; }
    public void setSubtitulo(String subtitulo) { this.subtitulo = subtitulo; }
    public String toString() {
        return (titulo + ", "+ subtitulo);
    }

}
