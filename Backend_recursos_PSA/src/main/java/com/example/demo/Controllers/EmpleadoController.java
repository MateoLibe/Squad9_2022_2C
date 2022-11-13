package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Empleado;
import com.example.demo.Service.EmpleadoService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/recursos")
@EnableSwagger2
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public List<Empleado> getEmpleados(){
        return empleadoService.getEmpleados();
    }

    @GetMapping("/empleado/{legajo}")
    public Empleado getSingleEmpleadoLegajo(@PathVariable Integer legajo){
        return empleadoService.getEmpleadoByLegajo(legajo);
    }

    @GetMapping("/empleado/{nombre, apellido}")
    public Empleado getSingleEmpleadoNombre(@PathVariable String nombre, @PathVariable String apellido){
        return empleadoService.getEmpleadoByNombre(nombre, apellido);
    }


        //SWAGGER

        @Bean
        public Docket apiDocket() {
            return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
        }
}
