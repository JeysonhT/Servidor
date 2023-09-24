package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.Interfaces.ServicioDao;
import com.servidor.servidor.Models.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiciosController {
    @Autowired
    ServicioDao servicioDao;

    @RequestMapping(value = "api/Servicios")
    public List<Servicios> getServicios(){
        return servicioDao.getServicios();
    }

    @RequestMapping(value = "api/Servicios/{Id}", method = RequestMethod.DELETE)
    public void EliminarServicios(@PathVariable int Id){
        servicioDao.EliminarServicio(Id);
    }


    @RequestMapping(value = "api/Servicios", method = RequestMethod.POST)
    public ResponseEntity<String>RegistrarServicio(@RequestParam String Nombre_serv, int Id_User, int Id_negocio, String Fecha, String Descripcion, Float costo){
        servicioDao.GuardarServicio(Nombre_serv, Id_User, Id_negocio, Fecha, Descripcion, costo);
        return ResponseEntity.ok("solicitud en proceso");
    }
}
