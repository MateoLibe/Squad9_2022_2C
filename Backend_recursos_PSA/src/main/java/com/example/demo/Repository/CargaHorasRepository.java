package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.Model.CargaHoras;

@Repository
public interface CargaHorasRepository  extends CrudRepository<CargaHoras,Integer>{
    
    @Query(value = "SELECT * FROM carga_horas_table c WHERE c.tarea_id=:tareaId",nativeQuery = true)
    public List<CargaHoras> findHorasByTarea(@Param("tareaId")Integer tareaId);

    @Query(value = "SELECT * FROM carga_horas_table c WHERE c.legajo=:legajoId",nativeQuery = true)
    public List<CargaHoras> findHorasByLegajo(Integer legajoId);
}
