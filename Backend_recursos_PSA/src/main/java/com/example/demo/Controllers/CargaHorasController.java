package com.example.demo.Controllers;

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
import com.example.demo.Model.CargaHoras;
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

    @PostMapping(path = "/cargas")
    @ResponseStatus(HttpStatus.CREATED)
    public CargaHoras createCargaHoras(@RequestBody CargaHoras cargaHorasTable){
        return cargaHorasService.createCarga(cargaHorasTable);
    }

    //GET
    @GetMapping(path = "/cargas/{cargaId}")
    public CargaHoras getCargaById(@PathVariable Integer cargaId){
        return cargaHorasService.getCargaById(cargaId);
    }

    @GetMapping(path = "/cargas")
    public List<CargaHoras> getAllCargas(){
        return cargaHorasService.getAll();
    }

    @GetMapping(path = "/reporte/tarea/{tareaId}")
    public List<CargaHoras> getReportesByTarea(@PathVariable Integer tareaId) throws Throwable{
        return cargaHorasService.getReportesPorTarea(tareaId);
    }

    @GetMapping(path = "/cargas/legajo/{legajo}")
    public List<CargaHoras> getCargasByLegajo(@PathVariable Integer legajo) throws Throwable{
        return cargaHorasService.getCargaHorasPorLegajo(legajo);
    }

    @GetMapping(path = "/reporte/proyecto/{proyecto_id}")
    public List<CargaHoras> getReportesByProyecto(@PathVariable Integer proyecto_id) throws Throwable{
        //url de proyecto necesitariamos
        return cargaHorasService.getReportesPorProyecto(proyecto_id);
    }
    
    @GetMapping(path = "/reporte/proyecto/{proyecto_id}/tiempoEstimado")
    public List<CargaHoras> getReportesPorTiempoEstimado(@PathVariable Integer proyecto_id, @RequestParam(required = true) String fecha_inferior, @RequestParam(required = true) String fecha_superior) throws Throwable{
        return cargaHorasService.getReportesPorTiempoEstimado(proyecto_id, fecha_inferior, fecha_superior);
    }

    @GetMapping(path = "/reporte/proyecto/{proyecto_id}/tiempoTotal")
    public Integer getSumaHorasTiempoEstimado(@PathVariable Integer proyecto_id) throws Throwable{
        return cargaHorasService.getSumaHorasTiempoEstimado(proyecto_id);
    }

     @GetMapping(path = "/reporte/proyecto/{legajo}/{proyecto_id}/tiempoEstimadoLegajo")
    public Integer getSumaHorasTiempoEstimadoLegajo(@PathVariable Integer legajo,@PathVariable Integer proyecto_id, @RequestParam(required = true) String fecha_inferior, @RequestParam(required = true) String fecha_superior) throws Throwable{
        return cargaHorasService.getSumaHorasTiempoEstimadoLegajo(legajo, proyecto_id, fecha_inferior, fecha_superior);
    }

    //PUT
    @PutMapping(path = "/cargas/{cargaId}")
    public CargaHoras updateCargaHoras(@PathVariable Integer cargaId, 
                                        @RequestParam(required = false) String fechaInicioNueva,
                                        @RequestParam(required = false) String fechaFinNueva,
                                       @RequestParam(required = false) Integer horasNuevas,
                                       @RequestParam(required = false) String estado,
                                       @RequestParam(required = false) Integer categoriaId,
                                       @RequestParam(required = false) Integer proyectoId,
                                       @RequestParam(required = false) Integer tareaId,
                                       @RequestParam(required = false) String nombreProyecto,
                                       @RequestParam(required = false) String nombreTarea, 
                                       @RequestParam(required = false) String nombreCategoria){
        return cargaHorasService.updateCargaHoras(cargaId,fechaInicioNueva, fechaFinNueva, horasNuevas, estado, categoriaId, proyectoId, tareaId, nombreProyecto, nombreTarea, nombreCategoria);
    }

    //DELETE
    @DeleteMapping(path = "/cargas/{cargaId}")
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
