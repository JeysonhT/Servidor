package com.servidor.servidor.Dao;

import com.servidor.servidor.Models.Negocio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NegocioDaoImp implements NegocioDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Negocio> getNegocios() {
        String query = "FROM Negocio";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void Eliminar(int Id) {
        Negocio negocio = entityManager.find(Negocio.class, Id);
        entityManager.remove(negocio);
    }

    @Override
    public void registrar(Negocio negocio) {
        entityManager.merge(negocio);
    }
}
