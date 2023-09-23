package com.servidor.servidor.Dao;

import java.util.List;

import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.servidor.servidor.Models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
@Transactional
public class UserDaoImp implements UserDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "From Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void Eliminar(int Id) {
        Usuario usuario = entityManager.find(Usuario.class, Id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
       entityManager.merge(usuario);
    }
    @Override
    public int getId(int Id){
        String query = "SELECT u.Id_User FROM Usuario u where u.Id_User =:iduser ";
        return entityManager.createQuery(query, Usuario.class).setParameter("iduser", Id).getFirstResult();
    }

    @Override
    public void verificarUsuario(Usuario usuario) {

    }


}
