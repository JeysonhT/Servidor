package com.servidor.servidor.Dao;

import java.util.List;

import com.servidor.servidor.Models.Usuario;

public interface UserDao {

    List<Usuario> getUsuarios();

    void Eliminar(int Id);

    void registrar(Usuario usuario);

    int getId(int id);

    void verificarUsuario(Usuario usuario);

}
