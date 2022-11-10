package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Empleado {

    @JsonProperty("legajo_id")
    private Integer legajo;

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    @JsonProperty("nombre")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("apellido")
    private String apellido;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Object getLegajo() {
        return legajo;
    }
    
}
