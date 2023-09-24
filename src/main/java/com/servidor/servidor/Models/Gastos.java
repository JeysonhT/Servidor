package com.servidor.servidor.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Gastos")
public class Gastos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "Id_Gastos")
    private int Id_Gastos;

    @Getter @Setter @Column(name = "Tipo_gasto")
    private String Tipo_gasto;

    @Getter @Setter @Column(name = "Monto")
    private float Monto;

    @ManyToOne
    @JoinColumn(name = "Id_Auto", referencedColumnName = "Id_Auto")
    @Getter @Setter
    private Automovil automovil;

    public Gastos() {
    }
}
