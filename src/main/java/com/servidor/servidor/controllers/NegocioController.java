package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.Interfaces.NegocioDao;
import com.servidor.servidor.Models.Negocio;
import com.servidor.servidor.Utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
public class NegocioController {
    @Autowired
    private NegocioDao negocioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("api/Negocio")
    public List<Negocio> getNegocio(){
        /*if(!validarToken(token)){
            return null;
        }*/
        return negocioDao.getNegocios();
    }

    @DeleteMapping("api/Negocio/{Id}")
    public ResponseEntity<String> EliminarNegocio(@PathVariable int Id, @RequestHeader(value = "Authorization" )String token){
        if(!validarToken(token)){
            return null;
        }
        negocioDao.Eliminar(Id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }

    @PostMapping("api/Negocio")
    public String RegistrarNegocio(@RequestBody Map<String, Object> mapa){
        return negocioDao.registrar(mapa);
    }

    private boolean validarToken(String token) {
        String NegocioId = jwtUtil.getKey(token);
        return NegocioId != null;
    }
}
