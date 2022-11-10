package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Empleado {

    @JsonProperty("legajo_id")
    private Integer legajo;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;
    
}
