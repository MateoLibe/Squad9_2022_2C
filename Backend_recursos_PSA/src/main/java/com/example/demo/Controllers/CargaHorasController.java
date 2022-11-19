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
import com.example.demo.Model.CargaHorasTable;
import com.example.demo.Service.CargaHorasService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/recursos")

public class CargaHorasController {
    
    @Autowired
    private CargaHorasService cargaHorasService;

    //POST

    public CargaHorasController(CargaHorasService cargaHorasService){
        this.cargaHorasService = cargaHorasService;
    }

    @PostMapping(path = "/carga")
    @ResponseStatus(HttpStatus.CREATED)
    public CargaHorasTable createCargaHoras(@RequestBody CargaHorasTable cargaHorasTable){
        return cargaHorasService.createCarga(cargaHorasTable);
    }

    //GET
    @GetMapping(path = "/carga/{cargaId}")
    public CargaHorasTable getCargaById(@PathVariable Integer cargaId){
        return cargaHorasService.getCargaById(cargaId);
    }

    @GetMapping(path = "/carga")
    public List<CargaHorasTable> getAllCargas(){
        return cargaHorasService.getAll();
    }

    @GetMapping(path = "/carga/tareaId/{tareaId}")
    public List<CargaHorasTable> getCargasByTarea(@PathVariable Integer tareaId) throws Throwable{
        return cargaHorasService.getCargaHorasPorTarea(tareaId);
    }

    @GetMapping(path = "/carga/legajo/{legajo}")
    public List<CargaHorasTable> getCargasByLegajo(@PathVariable Integer legajo) throws Throwable{
        return cargaHorasService.getCargaHorasPorLegajo(legajo);
    }

    //PUT
    @PutMapping(path = "/carga/{cargaId}")
    public CargaHorasTable updateCargaHoras(@PathVariable Integer cargaId,@RequestParam(required = false) String fechaNueva, @RequestParam(required = false) Integer horasNuevas){
        return cargaHorasService.updateCargaHoras(cargaId,fechaNueva,horasNuevas);
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
