package com.servidor.servidor.Dao;

import com.servidor.servidor.Dao.Interfaces.NegocioDao;
import com.servidor.servidor.Models.Afiliados;
import com.servidor.servidor.Models.Negocio;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Repository
@Transactional
public class NegocioDaoImp implements NegocioDao {
    @PersistenceContext
    EntityManager entityManager;

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Override
    @Transactional
    public List<Negocio> getNegocios() {
        String query = "FROM Negocio";
        return entityManager.createQuery(query, Negocio.class).getResultList();
    }

    @Override
    public void Eliminar(int Id) {
        Negocio negocio = entityManager.find(Negocio.class, Id);
        entityManager.remove(negocio);
    }

    @Transactional
    @Override
    public String registrar(Map<String, Object> mapa) {
        /*if (((int) mapa.get("telefono_negoc"))==0) {
            return ResponseEntity.badRequest().body("el numero del negocio esta vacio");
        }*/
        Negocio negocio = new Negocio();

        negocio.setNombre_negocio((String) mapa.get("nombre_negocio"));
        negocio.setPropietario((String) mapa.get("propietario"));
        negocio.setTelefono_negoc((int) mapa.get("telefono_negoc"));
        negocio.setDireccion((String) mapa.get("direccion"));
        negocio.setEmail((String) mapa.get("email"));

        String password = (String) mapa.get("clave_acceso");
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, password);
        negocio.setClave_acceso(hash);

        entityManager.merge(negocio);

        Negocio verify = verificarNegocio(negocio.getEmail(), password);

        if (verify != null) {
            Afiliados afiliados = new Afiliados();
            afiliados.setNegocio(verify);
            afiliados.setTipo((String) mapa.get("tipo"));
            entityManager.merge(afiliados);
            // Realizar operaciones adicionales con afiliados si es necesario
        }
        return "el negocio esta en proceso de registrarse";
    }

    @Override
    public Negocio verificarNegocio(String email, String clave_acceso) {
        String query = "FROM Negocio WHERE Email =:email";
        List<Negocio> lista = entityManager.createQuery(query, Negocio.class).setParameter("email", email)
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String hashPass = lista.get(0).getClave_acceso();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(hashPass, clave_acceso)) {
            return lista.get(0);
        }
        return null;

    }

    private void postAfiliado(Negocio negocio, String password, String tipo) {
        Negocio verify = verificarNegocio(negocio.getEmail(), password);

        if (verify != null) {
            Afiliados afiliados = new Afiliados();

            afiliados.setNegocio(verify);
            afiliados.setTipo(tipo);

            entityManager.merge(afiliados);  
        }
    }

    @Override
    public Afiliados getNegociobyId(int Id) {
        return entityManager.find(Afiliados.class, Id);
    }
    

}
