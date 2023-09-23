package com.servidor.servidor.controllers;

import java.net.http.HttpResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.servidor.servidor.Dao.UserDao;
import com.servidor.servidor.Models.Usuario;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/Usuarios")
    public List<Usuario> getUsuarios(){
        return userDao.getUsuarios();
    }

    @RequestMapping(value = "api/Usuarios/{Id}", method = RequestMethod.DELETE)
    public void DeleteUsuario(@PathVariable int Id){
        userDao.Eliminar(Id);
    }

    @RequestMapping(value = "api/Usuarios", method = RequestMethod.POST)
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario){
        userDao.registrar(usuario);
        return ResponseEntity.ok("solicitud procesada Correctamente");
    }
}
