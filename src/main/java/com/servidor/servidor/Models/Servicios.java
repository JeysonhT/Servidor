package com.servidor.servidor.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SERVICIOS")
public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "Id_Servicio")
    private int Id_Servicios;

    @Getter @Setter @Column(name = "NombreServ")
    private String NombreServ;

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

}
