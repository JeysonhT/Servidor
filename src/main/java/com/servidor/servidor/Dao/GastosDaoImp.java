package com.servidor.servidor.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.servidor.servidor.Dao.Interfaces.GastosDao;
import com.servidor.servidor.Models.Gastos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class GastosDaoImp implements GastosDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void registrarGasto(Gastos gasto) {
        entityManager.merge(gasto);

    }
    
    @Override
    public List<Gastos> getGastos() {
       String query = "FROM Gastos";
       return entityManager.createQuery(query, Gastos.class).getResultList();
    }

    @Override
    public void EliminarGasto(int Id) {
        Gastos gastos = entityManager.find(Gastos.class, Id);
        entityManager.remove(gastos);
    }

    @Override
    public float PromedioGastos() {
        String query = "FROM Gastos";
        List<Gastos> gastos = entityManager.createQuery(query, Gastos.class).getResultList();

        return promedio(gastos);
    }

    private float promedio (List<Gastos> lista){
        float suma = 0;

        for(Gastos gasto: lista){
            suma+=gasto.getMonto();
        }

        int cantidad = lista.size();

        if(cantidad > 0){
            return suma/cantidad;
        }else{
            return 0;
        }
    }

    
}
