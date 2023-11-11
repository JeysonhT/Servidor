package com.servidor.servidor.Dao;

import com.servidor.servidor.Dao.Interfaces.AutomovilDao;
import com.servidor.servidor.Models.Automovil;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AutomovilDaoImp implements AutomovilDao {

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Automovil> getAutos() {
        String query = "FROM Automovil";
        return entityManager.createQuery(query, Automovil.class).getResultList();
    }

    @Override
    public void EliminarAutos(int Id) {
        Automovil automovil = entityManager.find(Automovil.class, Id);
        entityManager.remove(automovil);
    }

    @Override
    public ResponseEntity<String> resgistrarAutos(Automovil automovil) {
        return null;
    }
}
