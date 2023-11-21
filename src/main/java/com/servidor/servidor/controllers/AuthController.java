package com.servidor.servidor.controllers;

import com.servidor.servidor.Dao.Interfaces.NegocioDao;
import com.servidor.servidor.Dao.Interfaces.UserDao;
import com.servidor.servidor.Models.Negocio;
import com.servidor.servidor.Models.Usuario;
import com.servidor.servidor.Utils.JWTUtil;

import java.util.Map;

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
    public String login(@RequestBody Map<String, String> usuario){
        String email = usuario.get("email");
        String clave_acceso = usuario.get("clave_acceso");
        Usuario usrLogin = userDao.verificarUsuario(email, clave_acceso);
       if(usrLogin != null){//verifica a los usuarios para iniciar sesion
           //retorna un token
           return jwtUtil.create(String.valueOf(usrLogin.getId_Usuario()), usrLogin.getEmail());
       }else{
           return "Verificacion fallida";
       }
    }
    @PostMapping("api/login/Negocio")
    public String loginNegocio(@RequestBody Map<String, String> negocio){
        String email = negocio.get("email");
        String clave_acceso = negocio.get("clave_acceso");
        Negocio negocioLogin = negocioDao.verificarNegocio(email, clave_acceso);
        if(negocioLogin != null){
            return jwtUtil.create(String.valueOf(negocioLogin.getId_negocio()), negocioLogin.getEmail());
        }else {
            return "veficacion fallida";
        }
    }




}
