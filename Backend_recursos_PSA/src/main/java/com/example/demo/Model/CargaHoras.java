package com.example.demo.Model;

public class CargaHoras {

    private CargaHorasTable horasTable;

    private Tarea tarea;

    private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public CargaHorasTable getHorasTable() {
        return horasTable;
    }

    public void setHorasTable(CargaHorasTable horasTable) {
        this.horasTable = horasTable;
    }

    public CargaHoras(){

    }

    
    
}
