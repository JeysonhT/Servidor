package com.servidor.servidor.Dao;

import com.servidor.servidor.Models.Negocio;
import com.servidor.servidor.Models.Servicios;
import com.servidor.servidor.Models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    public ResponseEntity<String> GuardarServicio(String Nombre_serv, int Id_User, int Id_negocio, String Fecha, String Descripcion, Float costo) {
        Usuario idusr = entityManager.find(Usuario.class, Id_User);
        Negocio idNegocio = entityManager.find(Negocio.class, Id_negocio);
        if(idusr!=null && idNegocio!=null){
            Servicios servicios = new Servicios(Nombre_serv, Fecha, Descripcion, costo);
            entityManager.merge(servicios);
        }else{
            return ResponseEntity.badRequest().body("los ids no coinciden en la base de datos");
        }
        return ResponseEntity.ok("Solicitud Ejecutada");
    }
}
