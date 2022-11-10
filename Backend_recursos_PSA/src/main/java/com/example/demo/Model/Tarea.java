package com.example.demo.Model;

public class Tarea {

    private Integer codigo;

    private String fecha_creacion;

    private String nombre;

    private String descripcion;

    public Tarea(Integer codigo, String fecha_creacion, String nombre, String descripcion){
        this.codigo = codigo;
        this.fecha_creacion = fecha_creacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
}
