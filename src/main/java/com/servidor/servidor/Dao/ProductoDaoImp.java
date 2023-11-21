package com.servidor.servidor.Dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.servidor.servidor.Dao.Interfaces.ProductoDao;
import com.servidor.servidor.Models.Producto;

import jakarta.persistence.EntityManager;

@Repository
@org.springframework.transaction.annotation.Transactional
public class ProductoDaoImp implements ProductoDao{

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Producto> getProductosforUser() {
        String query = "FROM Producto";
        return entityManager.createQuery(query, Producto.class).getResultList();
    }

    @Override
    public ResponseEntity<String> deleteProducto(int Id) {
        try{
            Producto producto = entityManager.find(Producto.class, Id);
            entityManager.remove(producto);
            return ResponseEntity.ok("El producto: "+producto.getNombre()+" fue eliminado");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("El producto ya no existe");
        }
    }

    @Override
    public String updateProducto(int Id, Producto producto) {
        try{
            String query = "UPDATE Producto SET Nombre = :nombre WHERE Id_producto = :id";
            entityManager.createQuery(query, Producto.class).setParameter("nombre", producto.getNombre()).setParameter("id",
                Id);
            entityManager.getTransaction().commit();
            return "Listo objeto actualizado";
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "El objeto no fue encontrado";
        }
    }

    @Override
    public ResponseEntity<String> postProducto(Producto producto) {
        try{
            entityManager.merge(producto);
            return ResponseEntity.ok("El producto fue registrado correctamente");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("ocurrio un error al ingresar el produto");
        }

    }

    @Override
    public Producto getProductobyId(int Id) {
        String query = "FROM Producto WHERE Id_producto =: Id";
        List<Producto> lista = entityManager.createQuery(query, Producto.class).setParameter("Id", Id).getResultList();
        Producto producto = lista.get(0);
        return producto;
    }

    @Override
    public List<Producto> getProductoforNegocio(int Id_afiliado) {
        String query = "FROM Producto WHERE Id_afiliado =: Id_afiliado";
        return entityManager.createQuery(query, Producto.class).setParameter("Id_afiliado", Id_afiliado).getResultList();
    }
    
    
}
