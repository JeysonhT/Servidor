package com.servidor.servidor.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Afiliados")
public class Negocio {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter @Column(name = "Id_Negocio")
    private int Id_negocio;
    @Getter @Setter @Column(name = "Nombre_Negocio")
    private String Nombre_negocio;
    @Getter @Setter @Column(name = "Nombre_Propiet")
    private String Propietario;
    @Getter @Setter @Column(name = "Num_cel_negoc")
    private int Celular_ngc;
    @Getter @Setter @Column(name = "Email_negocio")
    private String Email_negocio;
    @Getter @Setter @Column(name= "Ubicacion")
    private String Ubicacion;

    public Negocio() {
    }


}
