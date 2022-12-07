package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Categoria;


@Repository
public interface CategoriasRepository extends CrudRepository<Categoria,Integer>{
    
}
