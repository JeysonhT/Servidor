package com.servidor.servidor.Dao.Interfaces;

import com.servidor.servidor.Models.Vehiculo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AutomovilDao {
    List<Vehiculo> getAutos();

    List<Vehiculo> getAutosbyId(int id);

    void EliminarAutos(int Id);

    Vehiculo getVehiculobyid(int Id);

    ResponseEntity<String> resgistrarAutos(Vehiculo vehiculo);
}
