package com.servidor.servidor.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Gastos")
public class Gastos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "Id_Gasto")
    private int Id_Gasto;

    @Getter @Setter @Column(name = "Descripcion")
    private String Descripcion;

    @Getter @Setter @Column(name = "Monto")
    private float Monto;

    @Getter @Setter @Column(name = "Fecha")
    private String Fecha;

    @ManyToOne
    @JoinColumn(name = "Id_Vehiculo", referencedColumnName = "Id_Vehiculo")
    @Getter @Setter
    private Vehiculo vehiculo;

    public Gastos() {
    }
}
