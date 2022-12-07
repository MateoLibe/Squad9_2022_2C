package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import javax.persistence.*;
//import java.text.DateFormat;


@Entity
@Table(name = "carga_horas_table")
public class CargaHoras implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cargaId;

    @Column(name = "Fecha_inicio", length = 50)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String fecha_inicio;

    @Column(name = "Fecha_fin", length = 50)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String fecha_fin;

    @Column(name = "Cantidad_horas", length = 50)
    private Integer cantidad_horas;

    @Column(name = "proyecto_id", length = 50)
    private Integer proyecto_id;

    @Column(name = "tarea_id",length = 50)
    private Integer tarea_id;

    @Column(name = "legajo",length = 100)
    private Integer legajo;

    @Column(name = "nombre_tarea", length = 100)
    private String nombre_tarea;

    @Column(name = "nombre_proyecto", length = 100)
    private String nombre_proyecto;

    @Column(name = "estado", length = 100)
    private String estado;

    @Column(name = "categoriaId", length = 100)
    private Integer categoriaId;

    @Column(name = "categoriaNombre", length = 100)
    private String categoriaNombre;

	public CargaHoras(){}


    public CargaHoras(Integer cargaId, String fechaIni, String fechaFin, Integer cantidad_horas,
                      Integer tarea_id, Integer legajo, Integer proyecto_id,
                      String nombre_tarea, String nombre_proyecto, Integer categoriaId, String categoriaNombre){

        this.cargaId = cargaId;
        this.fecha_inicio = fechaIni;
        this.fecha_fin= fechaFin;
        this.cantidad_horas = cantidad_horas;
        this.legajo = legajo;
        this.tarea_id = tarea_id;
        this.proyecto_id = proyecto_id;
        this.nombre_proyecto = nombre_proyecto;
        this.nombre_tarea = nombre_tarea;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
    }

    
    public Integer getCodigo_carga() {
        return cargaId;
    }

    public void setCodigo_carga(Integer codigo_carga) {
        this.cargaId = codigo_carga;
    }

    public String getFechaInicio() {
        return fecha_inicio;
    }

    public String getFechaFin() {
        return fecha_fin;
    }


    public void setFechas(String fechaIni, String fechaFin) {
        this.fecha_inicio = fechaIni;
        this.fecha_fin = fechaFin;
    }

    
    public Integer getCantidad_horas() {
        return cantidad_horas;
    }


    public void setCantidad_horas(Integer cantidad_horas) {
        this.cantidad_horas = cantidad_horas;
    }

    public Integer getTarea_id() {
        return tarea_id;
    }


    public void setTarea_id(Integer tarea_id) {
        this.tarea_id = tarea_id;
    }
    
    public Object getLegajo() {
        return legajo;
    }


    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public void setProyectoId(Integer proyecto_id){
        this.proyecto_id = proyecto_id;
    }

    public Integer getProyectoId(){
        return proyecto_id;
    }

    public void setTareaNombre(String nombre_tarea){
        this.nombre_tarea = nombre_tarea;
    }

    public String getTareaNombre(){
        return nombre_tarea;
    }

    public void setProyectoNombre(String nombre_proyecto){
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getProyectoNombre(){
        return nombre_proyecto;
    }

    public String getEstado(){return estado;}
    public void setEstado(String estado){
        this.estado = estado;
    }

    public Integer getCategoria(){return categoriaId;}
    public void  setCategoria(Integer categoriaIdNuevo){this.categoriaId=categoriaIdNuevo;}

    public String getCategoriaNombre() {
		return categoriaNombre;
	}


	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}


}
