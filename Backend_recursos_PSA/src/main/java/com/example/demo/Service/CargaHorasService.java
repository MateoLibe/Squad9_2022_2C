package com.example.demo.Service;

//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    
}
