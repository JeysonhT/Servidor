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

@RestController
public class NegocioController {
    @Autowired
    private NegocioDao negocioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/Negocio")
    public List<Negocio> getNegocio(@RequestHeader(value = "Authorization") String token){
        if(!validarToken(token)){
            return null;
        }
        return negocioDao.getNegocios();
    }

    @RequestMapping(value = "api/Negocio/{Id}", method = RequestMethod.DELETE)
    public void EliminarNegocio(@PathVariable int Id){
        negocioDao.Eliminar(Id);
    }

    @RequestMapping(value = "api/Negocio", method = RequestMethod.POST)
    public ResponseEntity<String> RegistrarNegocio(@RequestBody Negocio negocio){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, negocio.getPassword());

        negocio.setPassword(hash);

        negocioDao.registrar(negocio);
        return ResponseEntity.ok("solicitud procesada Correctamente");
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
