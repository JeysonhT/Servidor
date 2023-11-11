package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.Interfaces.AutomovilDao;
import com.servidor.servidor.Models.Automovil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutomovilController {
    @Autowired
    private AutomovilDao automovilDao;

    @RequestMapping(value = "api/Automovil")
    public List<Automovil> getAutos(){
        return automovilDao.getAutos();
    }

    @DeleteMapping("api/Automovil/{Id}")
    public void EliminarAutos(@PathVariable int Id){
        automovilDao.EliminarAutos(Id);
    }

}
