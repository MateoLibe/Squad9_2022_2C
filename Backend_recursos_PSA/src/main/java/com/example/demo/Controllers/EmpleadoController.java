package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;

import com.example.demo.Model.Empleado;
import com.example.demo.Service.EmpleadoService;


public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public Collection<Empleado> getEmpleado() throws Throwable{
        return empleadoService.getEmpleados();
    }

    @GetMapping("/empleado/{legajo}")
    public Empleado getSingleEmpleado(integrer legajo) throws Throwable{
        return empleadoService.getEmpleadoByLegajo(legajo);
    }
}
