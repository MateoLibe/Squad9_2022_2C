package com.example.demo.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.Empleado;
import com.example.demo.Service.EmpleadoService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/recursos/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @GetMapping("/empleado")
    public Collection<Empleado> getEmpleados(){
        return empleadoService.getEmpleados();
    }

    @GetMapping("/empleado/{legajo}")
    public Empleado getEmpleadoById(@PathVariable Integer legajo){
        return empleadoService.getEmpleadoByLegajo(legajo);
    }

        //SWAGGER
    /* 
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
    }
    */
}
