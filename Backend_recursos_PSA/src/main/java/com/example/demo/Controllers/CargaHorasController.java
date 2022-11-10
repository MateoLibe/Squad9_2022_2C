package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.example.demo.Model.CargaHoras;
import com.example.demo.Service.CargaHorasService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/recursos")
@EnableSwagger2
public class CargaHorasController {
    
    @Autowired
    private CargaHorasService cargaHorasService;

    //POST

    @PostMapping(path = "/carga")
    @ResponseStatus(HttpStatus.CREATED)
    public CargaHoras createCargaHoras(@RequestBody CargaHoras cargaHoras){
        return cargaHorasService.createCarga(cargaHoras);
    }

    //GET
    @GetMapping(path = "/carga/{cargaId}")
    public CargaHoras getCargaById(@PathVariable Integer cargaId){
        return cargaHorasService.getCargaById(cargaId);
    }

    @GetMapping(path = "/carga")
    public List<CargaHoras> getAllCargas(){
        return cargaHorasService.getAll();
    }

    @GetMapping(path = "/carga/tareaId/{tareaId}")
    public List<CargaHoras> getCargasByTarea(@PathVariable Integer tareaId){
        return cargaHorasService.getCargaHorasPorTarea(tareaId);
    }

    @GetMapping(path = "/carga/legajo/{legajo}")
    public List<CargaHoras> getCargasByLegajo(@PathVariable Integer legajo){
        return cargaHorasService.getCargaHorasPorLegajo(legajo);
    }

    //PUT
    @PutMapping(path = "/carga/{cargaId}")
    public CargaHoras updateCargaHoras(@RequestBody CargaHoras cargaHoras,@PathVariable Integer cargaId,@RequestParam(required = false) String horasNuevas, @RequestParam(required = false) Integer cantidadHorasAct){
        return cargaHorasService.updateCargaHoras(cargaId,horasNuevas,cantidadHorasAct);
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
