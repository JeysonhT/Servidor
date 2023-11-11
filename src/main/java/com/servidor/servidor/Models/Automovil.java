package com.servidor.servidor.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Vehiculo")
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "Id_vehiculo")
    private int Id_Auto;

    @Getter @Setter @Column(name = "Modelo")
    private String Modelo;

    @Getter @Setter @Column(name = "Marca")
    private String Marca;

    @Getter @Setter @Column(name = "Anio")
    private int Anio;

    @ManyToOne
    @JoinColumn(name = "Id_Usuario", referencedColumnName = "Id_Usuario")
    @Getter @Setter
    private Usuario usuario;

    public Automovil() {
    }
}
