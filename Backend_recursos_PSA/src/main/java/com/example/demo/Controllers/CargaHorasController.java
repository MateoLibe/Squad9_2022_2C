package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.demo.Model.CargaHoras;
import com.example.demo.Model.CargaHorasTable;
import com.example.demo.Service.CargaHorasService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

//import java.time.LocalDate;
//import java.util.*;
//import java.sql.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/recursos")
public class CargaHorasController {
    
    @Autowired
    private CargaHorasService cargaHorasService;

    @PostMapping(path = "/carga")
    @ResponseStatus(HttpStatus.CREATED)
    public CargaHoras createCargaHoras(@RequestBody CargaHoras cargaHoras){
        return cargaHorasService.createCarga(cargaHoras);
    }
}
