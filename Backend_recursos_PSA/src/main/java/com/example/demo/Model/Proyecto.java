package com.example.demo.Model;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Proyecto {

    // @Id
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer proyecto_id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("tiempoEstimado")
    private Integer tiempoEstimado;

    public Proyecto(){}

    public Proyecto(Integer id, String nombre, Integer tiempo){
        this.proyecto_id = id;
        this.nombre = nombre;
        this.tiempoEstimado = tiempo;
    }

    public Integer getId(){
        return proyecto_id;
    }

    public Integer getEstimado(){
        return tiempoEstimado;
    }

    public String getNombre(){
        return nombre;
    }
}