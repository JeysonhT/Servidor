package com.servidor.servidor.Dao.Interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.servidor.servidor.Models.Producto;

public interface ProductoDao {
    List<Producto> getProductosforUser();

    ResponseEntity<String> deleteProducto(int Id);

    String updateProducto(int Id, Producto producto);

    ResponseEntity<String> postProducto(Producto producto);

    Producto getProductobyId(int Id);

    List<Producto> getProductoforNegocio(int Id_afiliado);
}
