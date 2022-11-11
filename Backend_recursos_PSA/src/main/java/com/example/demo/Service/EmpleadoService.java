package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.CargaHoras;
import com.example.demo.Repository.CargaHorasRepository;

import org.springframework.web.client.RestTemplate;
import java.util.*;

public class EmpleadoService {

    public Collection<Empleado> getEmpleados() throws Throwable{
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
    }

}
