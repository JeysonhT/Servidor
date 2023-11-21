package com.servidor.servidor.Dao.Interfaces;

import java.util.List;

import com.servidor.servidor.Models.Usuario;

public interface UserDao {

    List<Usuario> getUsuarios();

    void Eliminar(int Id);

    void registrar(Usuario usuario);

    Usuario getUserbyId(int Id);

    Usuario verificarUsuario(String email, String clave_acceso);

    //Metodos del usuario

    String EnviarWhatsapp(String telefono, String mensaje);
}
