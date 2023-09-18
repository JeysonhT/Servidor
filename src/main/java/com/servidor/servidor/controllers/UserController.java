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
    @RequestMapping(value = "User")
    public String User(){
        return "bienvenido";
    }

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return userDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios/{Id}")
    public void DeleteUsuario(@PathVariable int Id){
        userDao.Eliminar(Id);
    }

    /* Metodo auxiliar
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void PostUsuario(@RequestParam String Nombre1, String Nombre2, String Apellido1, String Apellido2, String Email, int Num_celular){
        Usuario usr = new Usuario();
        usr.setNombre1(Nombre1);
        usr.setNombre2(Nombre2);
        usr.setApellido1(Apellido1);
        usr.setApellido2(Apellido2);
        usr.setEmail(Email);
        usr.setNum_celular(Num_celular);
        userDao.registrar(usr);
    }*/

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario){
        userDao.registrar(usuario);
        return ResponseEntity.ok("solicitud procesada Correctamente");
    }
}
