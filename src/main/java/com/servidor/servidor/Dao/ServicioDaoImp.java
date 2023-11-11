package com.servidor.servidor.Dao;

import com.servidor.servidor.Dao.Interfaces.ServicioDao;
import com.servidor.servidor.Models.Servicios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ServicioDaoImp implements ServicioDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Servicios> getServicios() {
        String query = "FROM Servicios";
        return entityManager.createQuery(query, Servicios.class).getResultList();
    }

    @Override
    public void EliminarServicio(int Id) {
        Servicios servicios = entityManager.find(Servicios.class, Id);
        entityManager.remove(servicios);
    }

    @Override
    public ResponseEntity<String> GuardarServicio(String Fecha) {
        Servicios servicios = new Servicios(Fecha);
        entityManager.merge(servicios);
        return ResponseEntity.ok("Solicitud Ejecutada");
    }
}
