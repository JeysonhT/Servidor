package com.servidor.servidor.Dao;

import com.servidor.servidor.Dao.Interfaces.AutomovilDao;
import com.servidor.servidor.Models.Usuario;
import com.servidor.servidor.Models.Vehiculo;
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
    public List<Vehiculo> getAutos() {
        String query = "FROM Vehiculo";
        return entityManager.createQuery(query, Vehiculo.class).getResultList();
    }

    @Override
    public void EliminarAutos(int Id) {
        Vehiculo vehiculo = entityManager.find(Vehiculo.class, Id);
        entityManager.remove(vehiculo);
    }

    @Override
    public ResponseEntity<String> resgistrarAutos(Vehiculo vehiculo) {
        entityManager.merge(vehiculo);
        return ResponseEntity.ok("todo ok");
    }

    @Override
    public Vehiculo getVehiculobyid(int Id) {
        Vehiculo vehiculo = entityManager.find(Vehiculo.class, Id);
        return vehiculo;
    }

    @Override
    public List<Vehiculo> getAutosbyId(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);

        String query = "FROM Vehiculo WHERE usuario = :usuario";

        return entityManager.createQuery(query, Vehiculo.class).setParameter("usuario", usuario).getResultList();
    }
}
