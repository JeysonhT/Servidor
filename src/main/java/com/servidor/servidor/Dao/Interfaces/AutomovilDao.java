package com.servidor.servidor.Dao.Interfaces;

import com.servidor.servidor.Models.Automovil;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AutomovilDao {
    List<Automovil> getAutos();

    void EliminarAutos(int Id);

    ResponseEntity<String> resgistrarAutos(Automovil automovil);
}
