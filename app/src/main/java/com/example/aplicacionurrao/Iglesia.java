package com.example.aplicacionurrao;

import java.io.Serializable;

public class Iglesia implements Serializable {

    String nombreIglesia,descripcion;
    String fotoIglesia;

    public Iglesia(String nombreIglesia, String fotoIglesia, String descripcion ) {
        this.nombreIglesia = nombreIglesia;
        this.fotoIglesia = fotoIglesia;
        this.descripcion = descripcion;
    }

    public String getNombreIglesia() {
        return nombreIglesia;
    }

    public void setNombreIglesia(String nombreIglesia) {
        this.nombreIglesia = nombreIglesia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoIglesia() {
        return fotoIglesia;
    }

    public void setFotoIglesia(String fotoIglesia) { this.fotoIglesia = fotoIglesia;
    }
}
