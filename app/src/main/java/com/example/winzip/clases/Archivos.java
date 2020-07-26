package com.example.winzip.clases;

public class Archivos {
    private String nombre;
    private int imagenId;
    private String descripcion;


    public Archivos(String nombre,int imagen,String descripcion) {
        this.nombre = nombre;
        this.imagenId=imagen;
        this.descripcion=descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getNombre() {
        return nombre;
    }

    public int getImagenId() {
        return imagenId;
    }

    public String getDescripcion() {
        return descripcion;
    }



}
