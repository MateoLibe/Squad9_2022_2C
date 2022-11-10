package com.example.demo.Service;

import java.util.List;

//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Exceptions.IdTareaNotFoundException;
import com.example.demo.Model.CargaHorasTable;
import com.example.demo.Repository.CargaHorasRepository;

//import java.util.ArrayList;
//import java.util.Objects;

@Service
public class CargaHorasService {

    @Autowired
    private CargaHorasRepository cargaHorasRepository;

    public CargaHorasService(CargaHorasRepository cargaHorasRepository){
        this.cargaHorasRepository = cargaHorasRepository;
    }

    public List<CargaHorasTable> getCargaHorasPorTarea(Integer tareaId){

        if(tareaId == null){
            throw new IdTareaNotFoundException("la tarea que intenta mapear no existe");
        }
        return cargaHorasRepository.findHorasByTarea(tareaId);
    }

    public CargaHorasTable createCarga(CargaHorasTable cargaHoras){
        return cargaHorasRepository.save(cargaHoras);
    }

    @Transactional
    public CargaHorasTable updateCargaHoras(Integer cargaId, String fechaNueva, Integer cantidadHorasActualizada){
        
        CargaHorasTable cargaHoras = cargaHorasRepository.findById(cargaId).orElseThrow() -> new IdCargaNoEncontradaException("no existe ese id de carga");
        
        if(fechaNueva != cargaHoras.getFecha()){
            cargaHoras.setFecha(fechaNueva);
        }if(cantidadHorasActualizada != cargaHoras.getCantidad_horas()){
            cargaHoras.setCantidad_horas(cantidadHorasActualizada);
        }

        return cargaHorasRepository.save(cargaHoras);
    }
}
