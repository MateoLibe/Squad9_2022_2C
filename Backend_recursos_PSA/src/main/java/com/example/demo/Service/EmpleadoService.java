package com.example.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Empleado;

import java.util.*;

@Service
public class EmpleadoService {

    //@Autowired
    //private EmpleadoRepository empleadoRepository;

    public Collection<Empleado> getEmpleados(){
        String uri = "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/recursos-psa/1.0.0/m/api/recursos"; //falta el identificador de recursos uniforme no se de donde sacarlo?
        RestTemplate restTemplate = new RestTemplate();
        Empleado[] empleados = restTemplate.getForObject(uri, Empleado[].class);
        return Arrays.asList(empleados);
        //List<Empleado> empleados = new ArrayList<>();
        //empleadoRepository.findAll().forEach(empleados::add);
        //return empleados;
    }

    public Empleado getEmpleadoByLegajo(Integer legajo){
        
        ArrayList<Empleado> empleados = new ArrayList<>(getEmpleados());

        Empleado empleadoBuscado = empleados.stream().filter(empleado -> Objects.equals(legajo, empleado.getLegajo())).findAny().orElse(null);
        return empleadoBuscado;
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
