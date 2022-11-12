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


    /*public Collection<Empleado> getEmpleados() throws Throwable{
        String uri = "" //falta el identificador de recursos uniforme no se de donde sacarlo?
        RestTempate restTemplate = new RestTemplate();
        Empleado[] empleados = restTemplate.getForObject(uri, Empleado[].class);
        return Array.asList(empleados);
    }

    public Empleado getEmpleadoByLegajo(integrer legajo) throws Throwable{
        ArrayList<Empleado> empleados = new ArrayList<>(getEmpleados());

        Empleado empleadoBuscado = empleados.stream().filter(empleado -> Objetcs.equals(legajo, empleado.getLegajo()))
                .findAny().orElse(null);
        return empleadoBuscado;
    }*/

}
