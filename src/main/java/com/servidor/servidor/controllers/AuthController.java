package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.Interfaces.UserDao;
import com.servidor.servidor.Models.Usuario;
import com.servidor.servidor.Utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UserDao userDao;

    @Autowired
    JWTUtil jwtUtil;

    @RequestMapping(value = "api/Login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usrLogin = userDao.verificarUsuario(usuario);
       if(usrLogin != null){//verifica a los usurios para iniciar sesion
           //retorna un token
           return jwtUtil.create(String.valueOf(usrLogin.getId_User()), usrLogin.getEmail());
       }else{
           return "Verificacion fallida";
       }
    }



}
