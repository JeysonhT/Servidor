package com.servidor.servidor.Dao;

import com.servidor.servidor.Models.Servicios_Afiliados;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class Servicios_AfiliadosDaoImp implements Servicios_AfiliadosDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Servicios_Afiliados> getServicios_Afiliados() {
        String query = "FROM Servicios_Afiliados";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void EliminarServicios_Afiliados(int Id) {
        Servicios_Afiliados serviciosAfiliados = entityManager.find(Servicios_Afiliados.class, Id);
        entityManager.remove(serviciosAfiliados);
    }

    @Override
    public ResponseEntity<String> resgistrarServ_Afiliados(Servicios_Afiliados serviciosAfiliados) {
        return null;
    }
}
