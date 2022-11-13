package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Empleado;


@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,Integer>{

    @Query(value = "SELECT * FROM cempleados_table c WHERE c.nombre=:nombre",nativeQuery = true)
    public ArrayList<Empleado> findEmpleadoByNombre(@Param("nombre") String nombre);
}
