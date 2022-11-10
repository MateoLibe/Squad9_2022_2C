package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;

//import java.util.List;

import com.example.demo.Model.CargaHorasTable;


public interface CargaHorasRepository  extends CrudRepository<CargaHorasTable,String>{
    
}
