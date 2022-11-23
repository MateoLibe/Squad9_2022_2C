package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.Model.CargaHorasTable;

@Repository
public interface CargaHorasRepository  extends CrudRepository<CargaHorasTable,Integer>{
    
    @Query(value = "SELECT * FROM carga_horas_table c WHERE c.tarea_id=:tareaId",nativeQuery = true)
    public List<CargaHorasTable> findHorasByTarea(@Param("tareaId")Integer tareaId);

    @Query(value = "SELECT * FROM carga_horas_table c WHERE c.proyecto_id=:proyecto_id",nativeQuery = true)
    public List<CargaHorasTable> findHorasByProyecto(@Param("proyecto_id")Integer proyecto_id);

    @Query(value = "SELECT * FROM carga_horas_table c WHERE c.legajo=:legajoId",nativeQuery = true)
    public List<CargaHorasTable> findHorasByLegajo(Integer legajoId);
}
