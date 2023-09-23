package com.servidor.servidor.Dao;

import com.servidor.servidor.Models.Gastos;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GastosDaoImp implements GastosDao{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Gastos> getGastos() {
        String query = "FROM Gastos";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void EliminarGastos(int Id) {
        Gastos gastos = entityManager.find(Gastos.class, Id);
        entityManager.remove(gastos);
    }

    @Override
    public ResponseEntity<String> registrarGastos(Gastos gastos) {
        return null;
    }
}
