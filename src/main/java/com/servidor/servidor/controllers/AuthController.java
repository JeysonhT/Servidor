package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.Interfaces.NegocioDao;
import com.servidor.servidor.Dao.Interfaces.UserDao;
import com.servidor.servidor.Models.Negocio;
import com.servidor.servidor.Models.Usuario;
import com.servidor.servidor.Utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UserDao userDao;

    @Autowired
    NegocioDao negocioDao;

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
    @RequestMapping(value = "api/login/Negocio", method = RequestMethod.POST)
    public String loginNegocio(@RequestBody Negocio negocio){
        Negocio negocioLogin = negocioDao.verificarNegocio(negocio);
        if(negocioLogin != null){
            return jwtUtil.create(String.valueOf(negocioLogin.getId_negocio()), negocioLogin.getEmail_negocio());
        }else {
            return "veficacion fallida";
        }
    }




}
