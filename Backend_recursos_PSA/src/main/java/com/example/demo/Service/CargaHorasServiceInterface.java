package com.example.demo.Service;
import java.util.List;
import com.example.demo.Model.CargaHorasVieja;


public interface CargaHorasServiceInterface{

    List<CargaHorasVieja> getReportesPorTarea(Integer tareaId) throws Throwable;

    
    List<CargaHorasVieja> getCargaHorasPorLegajo(Integer legajoId) throws Throwable;

    CargaHorasVieja getCargaById(Integer cargaId);

    List<CargaHorasVieja> getAll();

    List<CargaHorasVieja> getReportesPorProyecto(Integer proyecto_id) throws Throwable;

    List<CargaHorasVieja> getReportesPorTiempoEstimado(Integer proyecto_id, String fecha_inferior, String fecha_superior) throws Throwable;

    CargaHorasVieja createCarga(CargaHorasVieja cargaHoras);

    CargaHorasVieja updateCargaHoras(Integer cargaId, String fechaNueva, Integer cantidadHorasActualizada, String estadoNuevo);

    void deleteByCargaId(Integer cargaId);
}