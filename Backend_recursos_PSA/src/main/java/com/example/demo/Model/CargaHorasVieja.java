package com.example.demo.Model;



public class CargaHorasVieja {
    
    private Empleado empleado;
    
    private CargaHoras carga;

    private Proyecto proyecto;

    private Tarea tarea;

    public CargaHorasVieja(){}

    public CargaHorasVieja(Empleado empleado, CargaHoras carga, Proyecto proyecto, Tarea tarea){
        this.empleado = empleado;
        this.carga = carga;
        this.proyecto = proyecto;
        this.tarea = tarea;
    }

    public void setEmpleado(Empleado empleado){
        this.carga.setLegajo((int)empleado.getLegajo());
    }

    public Empleado getEmpleado(){
        return this.empleado;
    }

    public void setProyecto(Proyecto proyecto){
        this.carga.setProyectoId(proyecto.getId());
        this.carga.setProyectoNombre(proyecto.getNombre());
    }

    public Proyecto getProyecto(){
        return this.proyecto;
    }

    public void setTarea(Tarea tarea){
        this.carga.setTarea_id(tarea.getCodigo());
        this.carga.setTareaNombre(tarea.getNombre());
    }

    public Tarea getTarea(){
        return this.tarea;
    }

}
