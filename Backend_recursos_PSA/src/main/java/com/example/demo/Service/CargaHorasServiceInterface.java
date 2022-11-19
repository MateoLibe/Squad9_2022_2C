package com.example.demo.Service;
import java.util.List;
import com.example.demo.Model.CargaHoras;


public interface CargaHorasServiceInterface{

    List<CargaHoras> getCargaHorasPorTarea(Integer tareaId) throws Throwable;

    
    List<CargaHoras> getCargaHorasPorLegajo(Integer legajoId) throws Throwable;

    CargaHoras getCargaById(Integer cargaId);

    List<CargaHoras> getAll();


    CargaHoras createCarga(CargaHoras cargaHoras);

    CargaHoras updateCargaHoras(Integer cargaId, String fechaNueva, Integer cantidadHorasActualizada);
}