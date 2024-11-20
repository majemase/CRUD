package com.example.crud;

import java.util.Date;

public class Tarea {
    private String titulo;
    private Date fecha_hora;
    private int categoria;

    public Tarea(String titulo, Date fecha_hora, int categoria) {
        this.titulo = titulo;
        this.fecha_hora = fecha_hora;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
