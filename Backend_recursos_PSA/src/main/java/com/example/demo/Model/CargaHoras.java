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

    @Column(name = "Fecha_carga", length = 50)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String fecha;

    @Column(name = "Cantidad_horas", length = 50)
    private Integer cantidad_horas;

    @Column(name = "tarea_id",length = 50)
    private Integer tarea_id;

    @Column(name = "legajo",length = 100)
    private Integer legajo;

    private Empleado empleado;

    public CargaHoras(){}


    public CargaHoras(Integer cargaId, String fecha, Integer cantidad_horas, Integer tarea_id, Integer legajo){

        this.cargaId = cargaId;
        this.fecha = fecha;
        this.cantidad_horas = cantidad_horas;
        this.legajo = legajo;
        this.tarea_id = tarea_id;

    }

    
    public Integer getCodigo_carga() {
        return cargaId;
    }

    public void setCodigo_carga(Integer codigo_carga) {
        this.cargaId = codigo_carga;
    }

    public String getFecha() {
        return fecha;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        return empleado.getLegajo();
    }


    public void setLegajo(Integer legajo) {
        empleado.setLegajo(legajo);
    }

}
