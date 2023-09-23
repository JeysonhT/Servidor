package com.servidor.servidor.Dao;

import com.servidor.servidor.Models.Usuario_Servicio;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Usuario_ServicioDao {
    List<Usuario_Servicio> getUsuario_Servicio();

    void EliminarUsuario_Servicio(int Id);

    ResponseEntity<String> registrarUsuario_Servicio(Usuario_Servicio usuarioServicio);
}
