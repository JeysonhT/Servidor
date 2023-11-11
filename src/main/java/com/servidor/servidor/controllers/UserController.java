package com.servidor.servidor.controllers;

import java.util.List;

import com.servidor.servidor.Utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.servidor.servidor.Dao.Interfaces.UserDao;
import com.servidor.servidor.Models.Usuario;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("api/Usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token){
        if (!validarToken(token)) {
            return null;
        }
        return userDao.getUsuarios();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @DeleteMapping("api/Usuarios/{Id}")
    public void DeleteUsuario(@RequestHeader(value="Authorization") String token,@PathVariable int Id){

        if (!validarToken(token)) {
            return;
        }

        userDao.Eliminar(Id);
    }

    @PostMapping("api/Usuarios")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getClave_acceso());

        usuario.setClave_acceso(hash);

        userDao.registrar(usuario);
        return ResponseEntity.ok("solicitud procesada Correctamente");
    }
}
