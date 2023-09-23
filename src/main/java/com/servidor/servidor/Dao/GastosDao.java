package com.servidor.servidor.Dao;

import com.servidor.servidor.Models.Gastos;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GastosDao {
    List<Gastos> getGastos();

    void EliminarGastos(int Id);

    ResponseEntity<String> registrarGastos(Gastos gastos);

}
