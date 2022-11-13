package com.example.demo.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
//import java.text.DateFormat;

@Entity
@Table(name = "carga_horas_table")
public class CargaHoras implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cargaId;

    @Column(name = "Fecha_carga")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "Cantidad_horas", length = 50)
    private Integer cantidad_horas;

    @Column(name = "tarea_id",length = 50)
    private Integer tarea_id;

    @Column(name = "legajo",length = 100)
    private Integer legajo;

    @Column(name = "proyecto_id",length = 100)
    private Integer proyecto_id;


    public CargaHoras(Integer cargaId, Date fecha, Integer cantidad_horas, Integer tarea_id, Integer legajo, Integer idProyecto) throws Throwable{

        this.cargaId = cargaId;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.fecha = sdf.parse(sdf.format(fecha));
        this.cantidad_horas = cantidad_horas;
        this.legajo = legajo;
        this.tarea_id = tarea_id;
        this.proyecto_id = idProyecto;

    }

    
    public Integer getCodigo_carga() {
        return cargaId;
    }

    public void setCodigo_carga(Integer codigo_carga) {
        this.cargaId = codigo_carga;
    }

    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
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

    public Integer getLegajo() {
        return legajo;
    }


    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

}
