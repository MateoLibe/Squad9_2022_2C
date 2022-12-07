package com.example.demo.Model;

import java.io.Serializable;
import javax.persistence.*;
//import java.text.DateFormat;


@Entity
@Table(name = "categoria_table")
public class Categoria implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCategoria;

    @Column(name="nombre", length = 50)
    private String nombre;

    @Column(name="descripcion", length = 200)
    private String descripcion;

    public Categoria() {}

    public Categoria(String nombre, String descripcion, Integer id){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.idCategoria=id;
    }

    public Integer getIdCategoria(){
        return idCategoria;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getNombre(){
        return nombre;
    }

    public void setIdCategoria(Integer id){
        this.idCategoria = id;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
}