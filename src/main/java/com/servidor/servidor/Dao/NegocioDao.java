package com.servidor.servidor.Dao;

import com.servidor.servidor.Models.Negocio;

import java.util.List;

public interface NegocioDao {
    List<Negocio> getNegocios();

    void Eliminar(int Id);

    void registrar(Negocio negocio);
}
