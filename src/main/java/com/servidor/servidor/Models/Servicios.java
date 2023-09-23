package com.servidor.servidor.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SERVICIOS")
public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "Id_Servicios")
    private int Id_Servicios;

    @Getter @Setter @Column(name = "nombre_Serv")
    private String Nombre_Serv;

    @Getter @Setter @Column(name = "Fecha")//nuevas
    private String Fecha;

    @Getter @Setter @Column(name = "Descripcion")
    private String Descripcion;

    @Getter @Setter @Column(name = "Costo")
    private float Costo;

    public Servicios() {
    }

    public Servicios(String nombre_Serv, String fecha, String descripcion, float costo) {
        Nombre_Serv = nombre_Serv;
        Fecha = fecha;
        Descripcion = descripcion;
        Costo = costo;
    }
}
