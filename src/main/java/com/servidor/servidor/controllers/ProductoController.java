package com.servidor.servidor.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.servidor.Dao.Interfaces.NegocioDao;
import com.servidor.servidor.Dao.Interfaces.ProductoDao;
import com.servidor.servidor.Models.Producto;

@RestController
public class ProductoController {
    @Autowired
    ProductoDao productoDao;

    @GetMapping("api/productos")
    public List<Producto> getProducto() {
        return productoDao.getProductosforUser();
    }

    @PostMapping("api/Productos")
    public ResponseEntity<String> postProducto(@RequestBody Map<String, Object> producto) {
        return productoDao.postProducto(producto);
    }

    @PostMapping("api/Productos/update")
    public String updateProducto(@RequestBody Map<String, Object> mapa) {
        int id = (Integer) mapa.get("Id");

        Producto producto = (Producto) mapa.get("producto");

        return productoDao.updateProducto(id, producto);
    }
}
