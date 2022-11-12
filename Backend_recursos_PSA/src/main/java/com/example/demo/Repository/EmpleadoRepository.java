package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Empleado;


@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,Integer>{
}
