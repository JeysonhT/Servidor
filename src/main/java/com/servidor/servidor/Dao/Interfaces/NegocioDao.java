package com.servidor.servidor.Dao.Interfaces;

import com.servidor.servidor.Models.Afiliados;
import com.servidor.servidor.Models.Negocio;

import java.util.List;
import java.util.Map;

public interface NegocioDao {
    List<Negocio> getNegocios();

    void Eliminar(int Id);

    Afiliados getNegociobyId(int Id);

    String registrar(Map<String, Object> mapa);

    Negocio verificarNegocio(String email, String clave_acceso);
}
