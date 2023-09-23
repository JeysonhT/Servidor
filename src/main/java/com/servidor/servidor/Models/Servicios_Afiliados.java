package com.servidor.servidor.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Servicios_Afiliados")
public class Servicios_Afiliados {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "Id_serv_Afiliados")
    private int Id_serv_Afiliados;

    @ManyToOne
    @JoinColumn(name = "Id_Servicios", referencedColumnName = "Id_Servicios")
    @Getter @Setter
    private Servicios servicios;

    @ManyToOne
    @JoinColumn(name = "Id_Negocio", referencedColumnName = "Id_Negocio")
    @Getter @Setter
    private Negocio negocio;

    public Servicios_Afiliados() {
    }
}
