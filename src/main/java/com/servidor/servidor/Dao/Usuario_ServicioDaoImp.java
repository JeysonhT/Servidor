package com.servidor.servidor.Dao;

import com.servidor.servidor.Dao.Interfaces.Usuario_ServicioDao;
import com.servidor.servidor.Models.Usuario_Servicio;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class Usuario_ServicioDaoImp implements Usuario_ServicioDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Usuario_Servicio> getUsuario_Servicio() {
        String query = "FROM Usuario_Servicio";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void EliminarUsuario_Servicio(int Id) {
        Usuario_Servicio usuarioServicio = entityManager.find(Usuario_Servicio.class, Id);
        entityManager.remove(usuarioServicio);
    }

    @Override
    public ResponseEntity<String> registrarUsuario_Servicio(Usuario_Servicio usuarioServicio) {
        return null;
    }
}
