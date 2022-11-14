package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.CargaHoras;
import com.example.demo.Repository.CargaHorasRepository;


@Service
public class CargaHorasService {

    @Autowired
    private CargaHorasRepository cargaHorasRepository;

    public CargaHorasService(CargaHorasRepository cargaHorasRepository){
        this.cargaHorasRepository = cargaHorasRepository;
    }

    //GETTERS

    public List<CargaHoras> getCargaHorasPorTarea(Integer tareaId){

        if(tareaId == null){
            throw new IllegalStateException("tarea con id" + tareaId + "no existe");
        }
        return cargaHorasRepository.findHorasByTarea(tareaId);
    }

    public List<CargaHoras> getCargaHorasPorLegajo(Integer legajoId){

        if(legajoId == null){
            throw new IllegalStateException("tarea con id" + legajoId + "no existe");
        }

        return cargaHorasRepository.findHorasByLegajo(legajoId);
    }

    public CargaHoras getCargaById(Integer cargaId){

        CargaHoras cargaHoras = cargaHorasRepository.findById(cargaId).orElseThrow(() -> new IllegalStateException("carga de horas con id" + cargaId + "no existe"));
        
        return cargaHorasRepository.save(cargaHoras);
    }

    public List<CargaHoras> getAll(){
        List<CargaHoras> cargaTotal = new ArrayList<>();
        cargaHorasRepository.findAll().forEach(cargaTotal::add);
        return cargaTotal;
    }

    //POSTS

    public CargaHoras createCarga(CargaHoras cargaHoras){
        return cargaHorasRepository.save(cargaHoras);
    }


    //PUTS

    @Transactional
    public CargaHoras updateCargaHoras(Integer cargaId, Date fechaNueva, Integer cantidadHorasActualizada){
        
        CargaHoras cargaHoras = cargaHorasRepository.findById(cargaId).orElseThrow(() -> new IllegalStateException("carga de horas con id" + cargaId + "no existe"));
        
        if(fechaNueva != cargaHoras.getFecha()){
            cargaHoras.setFecha(fechaNueva);
        }if(cantidadHorasActualizada != cargaHoras.getCantidad_horas()){
            cargaHoras.setCantidad_horas(cantidadHorasActualizada);
        }

        return cargaHorasRepository.save(cargaHoras);
    }

    public Integer getHorasDeProyecto(Integer idProyecto) {
       List<CargaHoras> cargas = cargaHorasRepository.findHorasByProyecto(idProyecto);
       Integer horas = cargas.stream().
       filter(carga->carga.getCantidad_horas()>0).
       mapToInt(carga->carga.getCantidad_horas()).sum();
       return horas;
    }

    public void deleteCargaHoras(Integer idCarga){
        cargaHorasRepository.deleteById(idCarga);
    }

}
