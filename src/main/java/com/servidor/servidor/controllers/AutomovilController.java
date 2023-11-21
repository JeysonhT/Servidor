package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.Interfaces.AutomovilDao;
import com.servidor.servidor.Dao.Interfaces.UserDao;
import com.servidor.servidor.Models.Usuario;
import com.servidor.servidor.Models.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AutomovilController {
    @Autowired
    private AutomovilDao automovilDao;

    @Autowired
    private UserDao userDao;
    @GetMapping(value = "api/Automovil")
    public List<Vehiculo> getAutos(){
        return automovilDao.getAutos();
    }

    @DeleteMapping("api/Automovil/{Id}")
    public void EliminarAutos(@PathVariable int Id) {
        automovilDao.EliminarAutos(Id);
    }

    @PostMapping("api/Automovil/Usuario")
    public List<Vehiculo> getVehiculoUsuario(@RequestBody Map<String, Integer> Id) {
        return automovilDao.getAutosbyId((int) Id.get("id_usuario"));
    }
    
    @PostMapping("api/Automovil")
    public ResponseEntity<String> postAutos(@RequestBody Map<String, Object> mapa) {
        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setModelo((String) mapa.get("modelo"));
        vehiculo.setMarca((String) mapa.get("marca"));
        vehiculo.setAnio((int) mapa.get("anio"));

        Usuario usuario = userDao.getUserbyId((int) mapa.get("id_usuario"));

        vehiculo.setUsuario(usuario);
        
        return automovilDao.resgistrarAutos(vehiculo);
    }

}
