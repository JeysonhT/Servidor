package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.Interfaces.NegocioDao;
import com.servidor.servidor.Dao.Interfaces.UserDao;
import com.servidor.servidor.Models.Negocio;
import com.servidor.servidor.Models.Usuario;
import com.servidor.servidor.Utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UserDao userDao;

    @Autowired
    NegocioDao negocioDao;

    @Autowired
    JWTUtil jwtUtil;

    @PostMapping("api/Login")
    public String login(@RequestBody Usuario usuario){
        Usuario usrLogin = userDao.verificarUsuario(usuario);
       if(usrLogin != null){//verifica a los usurios para iniciar sesion
           //retorna un token
           return jwtUtil.create(String.valueOf(usrLogin.getId_Usuario()), usrLogin.getEmail());
       }else{
           return "Verificacion fallida";
       }
    }
    @PostMapping("api/login/Negocio")
    public String loginNegocio(@RequestBody Negocio negocio){
        Negocio negocioLogin = negocioDao.verificarNegocio(negocio);
        if(negocioLogin != null){
            return jwtUtil.create(String.valueOf(negocioLogin.getId_negocio()), negocioLogin.getEmail_negocio());
        }else {
            return "veficacion fallida";
        }
    }




}
