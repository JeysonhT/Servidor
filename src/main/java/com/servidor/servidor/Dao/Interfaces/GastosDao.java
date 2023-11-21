package com.servidor.servidor.Dao.Interfaces;

import java.util.List;

import com.servidor.servidor.Models.Gastos;

public interface GastosDao {
    
    void registrarGasto(Gastos gasto);

    void EliminarGasto(int Id);

    List<Gastos> getGastos();

    float PromedioGastos();

}
