package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.Interfaces.NegocioDao;
import com.servidor.servidor.Models.Negocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NegocioController {
    @Autowired
    private NegocioDao negocioDao;

    @RequestMapping(value = "api/Negocio")
    public List<Negocio> getNegocio(){
        return negocioDao.getNegocios();
    }

    @RequestMapping(value = "api/Negocio/{Id}", method = RequestMethod.DELETE)
    public void EliminarNegocio(@PathVariable int Id){
        negocioDao.Eliminar(Id);
    }

    @RequestMapping(value = "api/Negocio", method = RequestMethod.POST)
    public ResponseEntity<String> RegistrarNegocio(@RequestBody Negocio negocio){
        negocioDao.registrar(negocio);
        return ResponseEntity.ok("solicitud procesada correctamente");
    }
}
