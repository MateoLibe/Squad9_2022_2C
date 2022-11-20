package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer tarea_id;

    private String fecha_creacion;

    private String nombre;

    private String descripcion;

    public Tarea(Integer tarea_id, String fecha_creacion, String nombre, String descripcion){
        this.tarea_id = tarea_id;
        this.fecha_creacion = fecha_creacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getCodigo() {
        return tarea_id;
    }

    public void setCodigo(Integer tarea_id) {
        this.tarea_id = tarea_id;
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
