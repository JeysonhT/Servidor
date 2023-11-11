package com.servidor.servidor.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Servicio")
public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "Id_Servicios")
    private int Id_Servicios;

    @Getter @Setter @Column(name = "Fecha")//nuevas
    private String Fecha;

    public Servicios() {
    }

    public Servicios(String fecha) {
        
        Fecha = fecha;
    }
}
