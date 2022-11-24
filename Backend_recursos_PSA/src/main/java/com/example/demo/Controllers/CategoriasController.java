package com.example.demo.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Categoria;
import com.example.demo.Model.Empleado;
import com.example.demo.Service.CategoriasService;
import com.example.demo.Service.EmpleadoService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/recursos/categoraias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriaService;

    public CategoriasController(CategoriasService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categoria")
    public Collection<Categoria> getCategorias(){
        return categoriaService.getCategorias();
    }

    @GetMapping("/categoria/{id}")
    public Categoria getSingleCategorais(Integer id){
        return categoriaService.getCategoriaById(id);
    }
}
