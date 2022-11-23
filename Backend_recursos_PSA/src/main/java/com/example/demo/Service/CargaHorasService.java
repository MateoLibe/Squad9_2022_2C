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

    public List<CargaHorasTable> getReportesPorTarea(Integer tareaId) throws Throwable{

        if(tareaId == null){
            throw new IllegalStateException("tarea con id" + tareaId + "no existe");
        }
        List<CargaHorasTable> cargaHorastable = new ArrayList<>();
        cargaHorasRepository.findHorasByTarea(tareaId).forEach(cargaHorastable::add);

        if(cargaHorastable.isEmpty()){
            throw new IllegalStateException("tarea con id" + tareaId + "no existe");
        }
        return cargaHorastable;
    }

    public List<CargaHorasTable> getCargaHorasPorLegajo(Integer legajoId) throws Throwable{

        if(legajoId == null){
            throw new IllegalStateException("empleado con id" + legajoId + "no existe");
        }

        List<CargaHorasTable> cargaHorastable = new ArrayList<>();
        cargaHorasRepository.findHorasByLegajo(legajoId).forEach(cargaHorastable::add);

        if(cargaHorastable.isEmpty()){
            throw new IllegalStateException("empleado con id" + legajoId + "no tiene nada asignado");
        }
        
        return cargaHorastable;
    }

    public CargaHorasTable getCargaById(Integer cargaId) {

        CargaHorasTable cargaHoras = cargaHorasRepository.findById(cargaId).orElseThrow(() -> new IllegalStateException("carga de horas con id" + cargaId + "no existe"));
        
        return cargaHorasRepository.save(cargaHoras);
    }

    public List<CargaHorasTable> getAll(){
        List<CargaHorasTable> cargaTotal = new ArrayList<>();
        cargaHorasRepository.findAll().forEach(cargaTotal::add);
        return cargaTotal;
    }

    public List<CargaHorasTable> getReportesPorProyecto(Integer proyecto_id) throws Throwable{

        if(proyecto_id == null){
            throw new IllegalStateException("empleado con id" + proyecto_id + "no existe");
        }
        List<CargaHorasTable> cargaDeHoras = new ArrayList<>();
        cargaHorasRepository.findHorasByProyecto(proyecto_id).forEach(cargaDeHoras::add); 

        if(cargaDeHoras.isEmpty()){
            throw new IllegalStateException("el proyecto con id" + proyecto_id + "no tiene cargas asignadas");
        }
        
        return cargaDeHoras;
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
        String fecha = cargaHorasTable.getFecha();
        Integer cantidadHoras = cargaHorasTable.getCantidad_horas();
        if(fechaNueva != cargaHorasTable.getFecha() && fechaNueva != null){
            cargaHorasTable.setFecha(fechaNueva);
        }if(cantidadHorasActualizada != cargaHorasTable.getCantidad_horas() && cantidadHorasActualizada != null){
            cargaHorasTable.setCantidad_horas(cantidadHorasActualizada);
        }
        if(fechaNueva == null){
            cargaHorasTable.setFecha(fecha);

        }
        if(cantidadHorasActualizada == null){
            cargaHorasTable.setCantidad_horas(cantidadHoras);
        }
        return cargaHorasRepository.save(cargaHorasTable);
    }

    //DELETE

    public void deleteByCargaId(Integer cargaId){
        this.cargaHorasRepository.deleteById(cargaId);
    }
}
