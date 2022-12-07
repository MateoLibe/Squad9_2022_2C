package com.example.demo.Service;


import java.text.SimpleDateFormat;
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

    public List<CargaHoras> getReportesPorTarea(Integer tareaId) throws Throwable{

        if(tareaId == null){
            throw new IllegalStateException("tarea con id" + tareaId + "no existe");
        }
        List<CargaHoras> cargaHorastable = new ArrayList<>();
        cargaHorasRepository.findHorasByTarea(tareaId).forEach(cargaHorastable::add);

        /*if(cargaHorastable.isEmpty()){
            throw new IllegalStateException("tarea con id" + tareaId + "no existe");
        }*/
        return cargaHorastable;
    }

    public List<CargaHoras> getCargaHorasPorLegajo(Integer legajoId) throws Throwable{

        if(legajoId == null){
            throw new IllegalStateException("empleado con id" + legajoId + "no existe");
        }

        List<CargaHoras> cargaHorastable = new ArrayList<>();
        cargaHorasRepository.findHorasByLegajo(legajoId).forEach(cargaHorastable::add);

        if(cargaHorastable.isEmpty()){
            throw new IllegalStateException("empleado con id" + legajoId + "no tiene nada asignado");
        }
        
        return cargaHorastable;
    }

    public CargaHoras getCargaById(Integer cargaId) {

        CargaHoras cargaHoras = cargaHorasRepository.findById(cargaId).orElseThrow(() -> new IllegalStateException("carga de horas con id" + cargaId + "no existe"));
        
        return cargaHorasRepository.save(cargaHoras);
    }

    public List<CargaHoras> getAll(){
        List<CargaHoras> cargaTotal = new ArrayList<>();
        cargaHorasRepository.findAll().forEach(cargaTotal::add);
        return cargaTotal;
    }

    public List<CargaHoras> getReportesPorProyecto(Integer proyecto_id) throws Throwable{

        if(proyecto_id == null){
            throw new IllegalStateException("proyecto con id" + proyecto_id + "no existe");
        }
        List<CargaHoras> cargaDeHoras = new ArrayList<>();
        cargaHorasRepository.findHorasByProyecto(proyecto_id).forEach(cargaDeHoras::add); 

        if(cargaDeHoras.isEmpty()){
            throw new IllegalStateException("el proyecto con id" + proyecto_id + "no tiene cargas asignadas");
        }
        
        return cargaDeHoras;
    }

    public List<CargaHoras> getReportesPorTiempoEstimado(Integer proyecto_id, String fecha_inferior, String fecha_superior) throws Throwable{
        
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha_inf = formato.parse(fecha_inferior);
        Date fecha_sup = formato.parse(fecha_superior);
        if(proyecto_id == null){
            throw new IllegalStateException("proyecto con id" + proyecto_id + "no existe");
        }

        List<CargaHoras> cargaDeHoras = new ArrayList<>();
        List<CargaHoras> cargaDeHorasPorTiempoEstimado = new ArrayList<>();
        cargaHorasRepository.findHorasByProyecto(proyecto_id).forEach(cargaDeHoras::add);
        
        for(CargaHoras carga : cargaDeHoras){
            Date fechaInicioCarga = formato.parse(carga.getFechaInicio());
            Date fechaFinCarga = formato.parse(carga.getFechaFin());
            if(!fechaInicioCarga.after(fecha_sup) && !fechaInicioCarga.before(fecha_inf) && fechaInicioCarga != null){
                if(!fechaFinCarga.after(fecha_sup) && !fechaFinCarga.before(fecha_inf) && fechaFinCarga != null)
                    cargaDeHorasPorTiempoEstimado.add(carga);
            }
        }

        return cargaDeHorasPorTiempoEstimado;
    }


    public Integer getSumaHorasTiempoEstimado(Integer proyecto_id) throws Throwable{
        Integer suma = 0;
        if(proyecto_id == null){
            throw new IllegalStateException("proyecto con id" + proyecto_id + "no existe");
        }

        List<CargaHoras> cargaDeHoras = new ArrayList<>();
        cargaHorasRepository.findHorasByProyecto(proyecto_id).forEach(cargaDeHoras::add);

        for(CargaHoras carga : cargaDeHoras){
            suma += carga.getCantidad_horas();
        }        
        return suma;
    }

    public Integer getSumaHorasTiempoEstimadoLegajo(Integer legajo,Integer proyecto_id, String fecha_inferior, String fecha_superior) throws Throwable{
        Integer suma = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha_inf = formato.parse(fecha_inferior);
        Date fecha_sup = formato.parse(fecha_superior);
        if(legajo == null){
            throw new IllegalStateException("legajo ingresado" + legajo + "no existe");
        }
        if(proyecto_id == null){
            throw new IllegalStateException("proyecto con id" + proyecto_id + "no existe");
        }

        List<CargaHoras> cargaDeHoras = new ArrayList<>();

        cargaHorasRepository.findHorasByLegajoProyecto(legajo,proyecto_id).forEach(cargaDeHoras::add);

        for(CargaHoras carga : cargaDeHoras){
            Date fechaInicioCarga = formato.parse(carga.getFechaInicio());
            Date fechaFinCarga = formato.parse(carga.getFechaFin());
            if(!fechaInicioCarga.after(fecha_sup) && !fechaInicioCarga.before(fecha_inf) && fechaInicioCarga != null){
                if(!fechaFinCarga.after(fecha_sup) && !fechaFinCarga.before(fecha_inf) && fechaFinCarga != null)
                    suma += carga.getCantidad_horas();
            }
        }        
        return suma;

    }

    //POSTS
    @Transactional
    public CargaHoras createCarga(CargaHoras cargaHoras){
        return cargaHorasRepository.save(cargaHoras);
    }


    //PUTS

    @Transactional
    public CargaHoras updateCargaHoras(Integer cargaId, String fechaInicioNueva, String fechaFinNueva, Integer cantidadHorasActualizada,
                                       String estadoNuevo, Integer categoriaIdNuevo, Integer proyectoIdNuevo, Integer tareaIdNuevo,
                                       String proyectoNombreNuevo, String tareaNombreNuevo, String categoriaNombreNuevo){
        
        CargaHoras cargaHorasTable = cargaHorasRepository.findById(cargaId).orElseThrow(() -> new IllegalStateException("carga de horas con id" + cargaId + "no existe"));
        String fechaInicio = cargaHorasTable.getFechaInicio();
        String fechaFin = cargaHorasTable.getFechaFin();
        Integer cantidadHoras = cargaHorasTable.getCantidad_horas();
        String estado = cargaHorasTable.getEstado();
        Integer categoriaId = cargaHorasTable.getCategoria();
        Integer proyectoIdActual = cargaHorasTable.getProyectoId();
        Integer tareaIdActual = cargaHorasTable.getTarea_id();
        String proyectoNombreActual = cargaHorasTable.getProyectoNombre();
        String tareaNombreActual = cargaHorasTable.getTareaNombre();
        String categoriaNombreActual = cargaHorasTable.getCategoriaNombre();

        if(fechaInicioNueva != fechaInicio && fechaInicioNueva != null && fechaFinNueva != fechaFin && fechaFinNueva != null){
            cargaHorasTable.setFechas(fechaInicioNueva, fechaFinNueva);
        }
        if(cantidadHorasActualizada != cargaHorasTable.getCantidad_horas() && cantidadHorasActualizada != null){
            cargaHorasTable.setCantidad_horas(cantidadHorasActualizada);
        }
        if(estadoNuevo!=null && estadoNuevo!=cargaHorasTable.getEstado()){
            cargaHorasTable.setEstado(estadoNuevo);
        }

        if(categoriaIdNuevo!=null && categoriaIdNuevo!=categoriaId){
            cargaHorasTable.setCategoria(categoriaIdNuevo);
        }

        if(proyectoIdActual!=null && proyectoIdActual!=proyectoIdNuevo){
            cargaHorasTable.setProyectoId(proyectoIdNuevo);
        }

        if(tareaIdNuevo!=null && tareaIdNuevo!=tareaIdActual){
            cargaHorasTable.setTarea_id(tareaIdNuevo);
        }

        if(proyectoNombreNuevo!=null && proyectoNombreNuevo!=proyectoNombreActual){
            cargaHorasTable.setProyectoNombre(proyectoNombreNuevo);
        }

        if(tareaNombreNuevo!=null && tareaNombreNuevo!=tareaNombreActual){
            cargaHorasTable.setTareaNombre(tareaNombreNuevo);
        }

        if(categoriaNombreNuevo!=null && categoriaNombreNuevo!=categoriaNombreActual){
            cargaHorasTable.setCategoriaNombre(categoriaNombreNuevo);
        }

        if(fechaInicioNueva == null || fechaFinNueva ==null){
             cargaHorasTable.setFechas(fechaInicio, fechaFin);
        }
        if(cantidadHorasActualizada == null){
            cargaHorasTable.setCantidad_horas(cantidadHoras);
        }
        if (estadoNuevo == null){
            cargaHorasTable.setEstado(estado);
        }

        if(categoriaIdNuevo == null){
            cargaHorasTable.setCategoria(cargaHorasTable.getCategoria());
        }
        if( proyectoIdNuevo == null){
            cargaHorasTable.setProyectoId(proyectoIdActual);
        }
        if( tareaIdNuevo == null){
            cargaHorasTable.setTarea_id(tareaIdActual);
        }
        if (proyectoNombreNuevo == null){
            cargaHorasTable.setProyectoNombre(proyectoNombreActual);
        }
        if( tareaNombreNuevo == null){
            cargaHorasTable.setTareaNombre(tareaNombreActual);
        }
        if( categoriaNombreNuevo == null){
            cargaHorasTable.setCategoriaNombre(categoriaNombreActual);
        }

        return cargaHorasRepository.save(cargaHorasTable);
    }

    //DELETE

    public void deleteByCargaId(Integer cargaId){
        this.cargaHorasRepository.deleteById(cargaId);
    }
}
