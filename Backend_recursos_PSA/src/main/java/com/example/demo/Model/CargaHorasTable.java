package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;

@Entity
@Table(name = "carga_horas_table")
public class CargaHorasTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo_carga;

    @Column(name = "Fecha de carga", length = 50)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String fecha;

    @Column(name = "Cantidad de horas", length = 50)
    private Integer cantidad_horas;


    public CargaHorasTable(String codigo_carga, String fecha, Integer cantidad_horas){

        this.codigo_carga = codigo_carga;
        this.fecha = fecha;
        this.cantidad_horas = cantidad_horas;

    }

    
    public Integer getCodigo_carga() {
        return codigo_carga;
    }

    public void setCodigo_carga(Integer codigo_carga) {
        this.codigo_carga = codigo_carga;
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

}
