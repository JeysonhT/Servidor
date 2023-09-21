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

    @ManyToOne
    @JoinColumn(name = "Id_user", referencedColumnName = "Id_User")
    @Getter @Setter
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "Id_Negocio", referencedColumnName = "Id_Negocio")
    @Getter @Setter
    private Negocio negocio;

    public Servicios() {
    }

    public Servicios(String nombre_Serv, Usuario usuario, Negocio negocio) {
        Nombre_Serv = nombre_Serv;
        this.usuario = usuario;
        this.negocio = negocio;
    }
}
