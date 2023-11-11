package com.servidor.servidor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.servidor.Dao.Interfaces.GastosDao;
import com.servidor.servidor.Models.Gastos;

@RestController
public class GastosController {

    @Autowired
    GastosDao gastosDao;

    @PostMapping("api/Gastos")
    public void registrarGastos(@RequestBody Gastos gastos){
        gastosDao.registrarGasto(gastos);
    }

    @GetMapping("api/Gastos")
    public List<Gastos> MostrarGastos(){
        return gastosDao.getGastos();
    }
    
}
