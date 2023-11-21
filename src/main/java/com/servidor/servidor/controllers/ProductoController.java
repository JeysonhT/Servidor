package com.servidor.servidor.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.servidor.Dao.Interfaces.ProductoDao;
import com.servidor.servidor.Models.Producto;

@RestController
public class ProductoController {
    @Autowired
    ProductoDao productoDao;

    @PostMapping("api/Productos")
    public ResponseEntity<String> postProducto(@RequestBody Producto producto) {
        return productoDao.postProducto(producto);
    }

    @PostMapping
    public String updateProducto(@RequestBody Map<String, Object> mapa) {
        int id = (Integer) mapa.get("Id");

        Producto producto = (Producto) mapa.get("producto");

        return productoDao.updateProducto(id, producto);
    }
}
