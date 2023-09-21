package com.servidor.servidor.Dao;

import com.servidor.servidor.Models.Negocio;
import com.servidor.servidor.Models.Servicios;
import com.servidor.servidor.Models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ServicioDaoImp implements ServicioDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Servicios> getServicios() {
        String query = "FROM Servicios";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void EliminarServicio(int Id) {
        Servicios servicios = entityManager.find(Servicios.class, Id);
        entityManager.remove(servicios);
    }

    @Override
    public ResponseEntity<String> GuardarServicio(String Nombre_serv, int id_User, int Id_negocio) {
        Usuario idusr = entityManager.find(Usuario.class, id_User);
        Negocio idNegocio = entityManager.find(Negocio.class, Id_negocio);
        if(idusr!=null && idNegocio!=null){
            Servicios servicios = new Servicios(Nombre_serv, idusr, idNegocio);
            entityManager.merge(servicios);
        }else{
            return ResponseEntity.badRequest().body("los ids no coinciden en la base de datos");
        }
        return ResponseEntity.ok("La solicitud fue ejecutada correctamente");
    }
}
