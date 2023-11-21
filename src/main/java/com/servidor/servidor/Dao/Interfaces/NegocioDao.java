package com.servidor.servidor.Dao.Interfaces;

import com.servidor.servidor.Models.Negocio;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface NegocioDao {
    List<Negocio> getNegocios();

    void Eliminar(int Id);

    ResponseEntity<String> registrar(Map<String, Object> mapa);

    Negocio verificarNegocio(String email, String clave_acceso);
}
