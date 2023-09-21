package com.servidor.servidor.Dao;

import com.servidor.servidor.Models.Servicios;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServicioDao {
    List<Servicios> getServicios();
    void EliminarServicio(int Id);

     ResponseEntity<String> GuardarServicio(String Nombre_serv, int Id_User, int Id_negocio);


}
