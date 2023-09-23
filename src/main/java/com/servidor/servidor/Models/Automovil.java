package com.servidor.servidor.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Automovil")
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "Id_Auto")
    private int Id_Auto;

    @Getter @Setter @Column(name = "Modelo")
    private String Modelo;

    @Getter @Setter @Column(name = "Marca")
    private String Marca;

    @Getter @Setter @Column(name = "Anio")
    private String Anio;

    @ManyToOne
    @JoinColumn(name = "Id_User", referencedColumnName = "Id_User")
    @Getter @Setter
    private Usuario usuario;

    public Automovil() {
    }
}
