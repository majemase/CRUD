package com.example.crud;

import java.util.Date;

public class Tarea {
    private int id;
    private String titulo;
    private Date fecha_hora;
    private int categoria;
    private String descripcion;

    public Tarea(int id, String titulo, Date fecha_hora, int categoria, String descripcion) {
        this.titulo = titulo;
        this.fecha_hora = fecha_hora;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
