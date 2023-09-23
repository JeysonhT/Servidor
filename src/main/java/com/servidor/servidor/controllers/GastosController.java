package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.GastosDao;
import com.servidor.servidor.Models.Gastos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GastosController {
    @Autowired
    private GastosDao gastosDao;

    @RequestMapping(value = "api/Gastos")
    public List<Gastos> getGastos(){
        return gastosDao.getGastos();
    }

    @RequestMapping(value = "api/Gastos/{Id}", method = RequestMethod.DELETE)
    public void EliminarGastos(@PathVariable int Id){
        gastosDao.EliminarGastos(Id);
    }
}
