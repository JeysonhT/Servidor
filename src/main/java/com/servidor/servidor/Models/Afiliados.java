package com.servidor.servidor.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Afiliados")
public class Afiliados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "Id_afiliado")
    private  int Id_afiliado;

    @ManyToOne
    @JoinColumn(name = "Id_negocio", referencedColumnName = "Id_negocio")
    @Getter @Setter
    private Negocio negocio;

    @Getter @Setter @Column(name = "Tipo")
    private String Tipo;

    public Afiliados() {
    }
}
