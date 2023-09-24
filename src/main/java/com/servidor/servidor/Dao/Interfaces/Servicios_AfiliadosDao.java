package com.servidor.servidor.Dao.Interfaces;

import com.servidor.servidor.Models.Servicios_Afiliados;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Servicios_AfiliadosDao {
    List<Servicios_Afiliados> getServicios_Afiliados();

    void EliminarServicios_Afiliados(int Id);

    ResponseEntity<String> resgistrarServ_Afiliados(Servicios_Afiliados serviciosAfiliados);

}
