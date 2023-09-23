package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.UserDao;
import com.servidor.servidor.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "api/Login", method = RequestMethod.POST)
    public void Login(@RequestBody Usuario usuario){
        userDao.verificarUsuario(usuario);
    }



}
