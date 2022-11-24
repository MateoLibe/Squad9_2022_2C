package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Categoria;
import com.example.demo.Model.Empleado;


@Repository
public interface CategoriasRepository extends CrudRepository<Categoria,Integer>{
    
}
