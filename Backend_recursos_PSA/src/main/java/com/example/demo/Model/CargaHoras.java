package com.example.demo.Model;



public class CargaHoras {
    
    private Empleado empleado;
    
    private CargaHorasTable carga;

    private Proyecto proyecto;

    public CargaHoras(){}

    public CargaHoras(Empleado empleado, CargaHorasTable carga, Proyecto proyecto){
        this.empleado = empleado;
        this.carga = carga;
        this.proyecto = proyecto;
    }

    public void setEmpleado(Empleado empleado){
        carga.setLegajo((int)empleado.getLegajo());
    }

    public Empleado getEmpleado(){
        return this.empleado;
    }

    public void setProyecto(Proyecto proyecto){
        carga.setProyectoId(proyecto.getId());
    }

    public Proyecto getProyecto(){
        return this.proyecto;
    }

}
