package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Categoria;
import com.example.demo.Repository.CategoriasRepository;

import java.util.*;

@Service
public class CategoriasService {

    @Autowired
    CategoriasRepository categoriasRepository;

    public CategoriasService(CategoriasRepository repository){
        this.categoriasRepository=repository;
    }
    
    public Collection<Categoria> getCategorias(){
        List<Categoria> todaCategoria = new ArrayList<>();
        categoriasRepository.findAll().forEach(todaCategoria::add);
        return todaCategoria;
    }


    public Categoria getCategoriaById(Integer id){
        
        ArrayList<Categoria> categorias = new ArrayList<>(getCategorias());

        Categoria categoriaBuscada = categorias.stream().filter(categoria -> Objects.equals(id, categoria.getIdCategoria())).findAny().orElse(null);
        return categoriaBuscada;
    }
}
