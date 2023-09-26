package com.servidor.servidor.Dao;

import com.servidor.servidor.Dao.Interfaces.NegocioDao;
import com.servidor.servidor.Models.Negocio;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NegocioDaoImp implements NegocioDao {
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

    @Override
    public Negocio verificarNegocio(Negocio negocio) {
        String query = "FROM Negocio WHERE Email_negocio =:email";
        List<Negocio> lista = entityManager.createQuery(query).setParameter("email", negocio.getEmail_negocio()).getResultList();

        if(lista.isEmpty()){
            return null;
        }

        String hashPass = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(hashPass, negocio.getPassword())){
            return lista.get(0);
        }
        return null;

    }


}
