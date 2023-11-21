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
@Table(name = "Negocio")
public class Negocio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "Id_Negocio")
    private int Id_negocio;
    @Getter @Setter @Column(name = "Nombre_Negocio")
    private String Nombre_negocio;
    @Getter @Setter @Column(name = "Nombre_Propiet")
    private String Propietario;
    @Getter @Setter @Column(name = "Telefono_negoc")
    private int Telefono_negoc;
    @Getter @Setter @Column(name = "Email")
    private String Email;
    @Getter @Setter @Column(name= "Direccion")
    private String Direccion;
    @Getter @Setter @Column(name = "Clave_acceso")
    private String Clave_acceso;

    public Negocio() {
    }


}
