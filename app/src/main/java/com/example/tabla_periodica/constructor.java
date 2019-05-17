package com.example.tabla_periodica;

public class constructor {
    private int foto;
    private String elemento,contenido;

    public constructor(int foto,String elemento,String contenido){
        this.foto=foto;
        this.elemento=elemento;
        this.contenido=contenido;

    }
    public int getFoto(){return foto;}
    public String getElemento(){return elemento;}
    public String getContenido(){return contenido;}
}
