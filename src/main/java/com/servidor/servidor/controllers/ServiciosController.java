package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.Interfaces.ServicioDao;
import com.servidor.servidor.Models.Servicios;
import com.servidor.servidor.Utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiciosController {
    @Autowired
    ServicioDao servicioDao;

    @Autowired
    JWTUtil jwtUtil;

    @RequestMapping(value = "api/Servicios")
    public List<Servicios> getServicios(@RequestHeader(value = "Authorization") String token){
        if(!validarToken(token)){
            return null;
        }

        return servicioDao.getServicios();
    }

    @DeleteMapping("api/Servicios/{Id}")
    public ResponseEntity<String> EliminarServicios(@PathVariable int Id, @RequestHeader(value = "Authorization")String token){
        if(!validarToken(token)){
            return null;
        }
        servicioDao.EliminarServicio(Id);
        return ResponseEntity.ok("Servicio eliminado correctamente");
    }


    @PostMapping("api/Servicios")
    public ResponseEntity<String>RegistrarServicio(@RequestParam String Fecha, @RequestHeader(value = "Authorization")String token){
        if(!validarToken(token)){
            return null;
        }
        servicioDao.GuardarServicio(Fecha);
        return ResponseEntity.ok("solicitud en proceso");
    }

    private boolean validarToken(String token) {
        String NegocioId = jwtUtil.getKey(token);
        return NegocioId != null;
    }
}
