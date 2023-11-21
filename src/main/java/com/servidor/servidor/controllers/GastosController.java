package com.servidor.servidor.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.servidor.Dao.Interfaces.AutomovilDao;
import com.servidor.servidor.Dao.Interfaces.GastosDao;
import com.servidor.servidor.Models.Gastos;
import com.servidor.servidor.Models.Vehiculo;

@RestController
public class GastosController {

    @Autowired
    GastosDao gastosDao;

    @Autowired
    AutomovilDao automovilDao;

    @PostMapping("api/Gastos")
    public void registrarGastos(@RequestBody Map<String, Object> mapa) {
        Gastos gastos = new Gastos();
        gastos.setDescripcion((String) mapa.get("descripcion"));
        gastos.setFecha((String) mapa.get("fecha"));
        gastos.setMonto(((Number) mapa.get("monto")).floatValue());

        int id = (int) mapa.get("id_vehiculo");

        Vehiculo vehiculo = automovilDao.getVehiculobyid(id);

        gastos.setVehiculo(vehiculo);

        gastosDao.registrarGasto(gastos);
    }

    @GetMapping("api/Gastos")
    public List<Gastos> MostrarGastos(){
        return gastosDao.getGastos();
    }
    
}
