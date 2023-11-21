package com.servidor.servidor.Dao;

import java.util.List;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
        return entityManager.createQuery(query, Usuario.class).getResultList();
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
    public Usuario verificarUsuario(String email, String clave_acceso) {//metodo de comprobacion de credenciales
        String query = "From Usuario WHERE Email = :email";
        List<Usuario> lista = entityManager.createQuery(query, Usuario.class).setParameter("email", email).getResultList();

        if(lista.isEmpty()){
            return null;
        }
        String hashPass = lista.get(0).getClave_acceso();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(hashPass, clave_acceso)){
            return lista.get(0);
        }
        return null;
    }

    @Override
    public String EnviarWhatsapp(String telefono, String mensaje) {
        try{
            String url = "https://api.whatsapp.com/send";
            String encodemensaje = URLEncoder.encode(mensaje, "UTF-8");

            return String.format("%s?phone=%s&text=%s", url,telefono, encodemensaje);
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario getUserbyId(int Id) {
        return entityManager.find(Usuario.class, Id);
    }

    
}
