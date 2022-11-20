package com.example.demo.Model;


//import java.text.DateFormat;


public class CargaHoras {
    
    private Empleado empleado;
    
    private CargaHorasTable carga;

    public CargaHoras(){}

    public CargaHoras(Empleado empleado, CargaHorasTable carga){
        this.empleado = empleado;
        this.carga = carga;
    }

    public void setEmpleado(Empleado empleado){
        carga.setLegajo((int)empleado.getLegajo());
    }

    public Object getEmpleado(){
        return this.empleado.getLegajo();
    }
}
