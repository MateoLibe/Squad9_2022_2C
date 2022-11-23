package com.example.demo.Controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping(path = "/reporte/tarea/{tareaId}")
    public List<CargaHorasTable> getReportesByTarea(@PathVariable Integer tareaId) throws Throwable{
        return cargaHorasService.getReportesPorTarea(tareaId);
    }

    @GetMapping(path = "/carga/legajo/{legajo}")
    public List<CargaHorasTable> getCargasByLegajo(@PathVariable Integer legajo) throws Throwable{
        return cargaHorasService.getCargaHorasPorLegajo(legajo);
    }

    @GetMapping(path = "/reporte/proyecto/{proyecto_id}")
    public List<CargaHorasTable> getReportesByProyecto(@PathVariable Integer proyecto_id) throws Throwable{
        //url de proyecto necesitariamos
        return cargaHorasService.getReportesPorProyecto(proyecto_id);
    }
    
    @GetMapping(path = "/reporte/proyecto/{proyecto_id}/tiempoEstimado")
    public List<CargaHorasTable> getReportesPorTiempoEstimado(@PathVariable Integer proyecto_id,@RequestParam(required = true) String fecha_inferior,@RequestParam(required = true) String fecha_superior) throws Throwable{
        return cargaHorasService.getReportesPorTiempoEstimado(proyecto_id, fecha_inferior, fecha_superior);
    }

    //PUT
    @PutMapping(path = "/carga/{cargaId}")
    public CargaHorasTable updateCargaHoras(@PathVariable Integer cargaId,@RequestParam(required = false) String fechaNueva, @RequestParam(required = false) Integer horasNuevas){
        return cargaHorasService.updateCargaHoras(cargaId,fechaNueva,horasNuevas);
    }

    //DELETE
    @DeleteMapping(path = "/deleteCarga/{cargaId}")
    public void deleteCargaById(@PathVariable Integer cargaId){
        cargaHorasService.deleteByCargaId(cargaId);
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
