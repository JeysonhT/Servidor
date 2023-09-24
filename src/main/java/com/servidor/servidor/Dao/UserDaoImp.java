package com.servidor.servidor.Dao;

import java.util.List;

import com.servidor.servidor.Dao.Interfaces.UserDao;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.servidor.servidor.Models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
@Transactional
public class UserDaoImp implements UserDao {
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
    public int getId(int Id){//metodo no usado aun
        String query = "SELECT u.Id_User FROM Usuario u where u.Id_User =:iduser ";
        return entityManager.createQuery(query, Usuario.class).setParameter("iduser", Id).getFirstResult();
    }

    @Override
    public Usuario verificarUsuario(Usuario usuario) {//metodo de comprobacion de credenciales
        String query = "From Usuario WHERE Email = :email";
        List<Usuario> lista = entityManager.createQuery(query).setParameter("email", usuario.getEmail()).getResultList();

        if(lista.isEmpty()){
            return null;
        }
        String hashPass = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(hashPass, usuario.getPassword())){
            return lista.get(0);
        }
        return null;
    }


}
