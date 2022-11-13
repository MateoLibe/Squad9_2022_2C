package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Empleado;
import com.example.demo.Repository.EmpleadoRepository;

import java.util.*;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getEmpleados(){
        List<Empleado> empleados = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleados::add);
        return empleados;
    }

    public Empleado getEmpleadoByLegajo(Integer legajo){
        
        Empleado empleado = empleadoRepository.findById(legajo).orElseThrow(() -> new IllegalStateException("empleado con legajo" + legajo + "no existe"));
        return empleadoRepository.save(empleado);
    }


    public Empleado getEmpleadoByNombre(String nombre, String apellido){
        ArrayList<Empleado> empleados = empleadoRepository.findEmpleadoByNombre(nombre);
        
        Empleado empleadoBuscado = empleados.stream()
        .filter(empleado-> Objects.equals(apellido, empleado.getApellido()))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("empleado" + apellido + "," + nombre +"no existe"));
        return empleadoRepository.save(empleadoBuscado);
    }
}
