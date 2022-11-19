package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.CargaHorasTable;
import com.example.demo.Repository.CargaHorasRepository;


@Service
public class CargaHorasService {

    @Autowired
    private CargaHorasRepository cargaHorasRepository;

    public CargaHorasService(CargaHorasRepository cargaHorasRepository){
        this.cargaHorasRepository = cargaHorasRepository;
    }

    //GETTERS

    public List<CargaHorasTable> getCargaHorasPorTarea(Integer tareaId){

        if(tareaId == null){
            throw new IllegalStateException("tarea con id" + tareaId + "no existe");
        }
        return cargaHorasRepository.findHorasByTarea(tareaId);
    }

    public List<CargaHorasTable> getCargaHorasPorLegajo(Integer legajoId){

        if(legajoId == null){
            throw new IllegalStateException("tarea con id" + legajoId + "no existe");
        }

        return cargaHorasRepository.findHorasByLegajo(legajoId);
    }

    public CargaHorasTable getCargaById(Integer cargaId){

        CargaHorasTable cargaHoras = cargaHorasRepository.findById(cargaId).orElseThrow(() -> new IllegalStateException("carga de horas con id" + cargaId + "no existe"));
        
        return cargaHorasRepository.save(cargaHoras);
    }

    public List<CargaHorasTable> getAll(){
        List<CargaHorasTable> cargaTotal = new ArrayList<>();
        cargaHorasRepository.findAll().forEach(cargaTotal::add);
        return cargaTotal;
    }

    //POSTS
    @Transactional
    public CargaHorasTable createCarga(CargaHorasTable cargaHoras){
        return cargaHorasRepository.save(cargaHoras);
    }


    //PUTS

    @Transactional
    public CargaHorasTable updateCargaHoras(Integer cargaId, String fechaNueva, Integer cantidadHorasActualizada){
        
        CargaHorasTable cargaHorasTable = cargaHorasRepository.findById(cargaId).orElseThrow(() -> new IllegalStateException("carga de horas con id" + cargaId + "no existe"));
        
        if(fechaNueva != cargaHorasTable.getFecha()){
            cargaHorasTable.setFecha(fechaNueva);
        }if(cantidadHorasActualizada != cargaHorasTable.getCantidad_horas()){
            cargaHorasTable.setCantidad_horas(cantidadHorasActualizada);
        }

        return cargaHorasRepository.save(cargaHorasTable);
    }


}
