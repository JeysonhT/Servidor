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
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "Id_Usuario")
    private int Id_Usuario;

    @Getter @Setter @Column(name = "Nombre1")
    private String Nombre1;
    @Getter @Setter @Column(name = "Nombre2")
    private String Nombre2;
    @Getter @Setter @Column(name = "Apellido1")
    private String Apellido1;
    @Getter @Setter @Column(name = "Apellido2")
    private String Apellido2;
    @Getter @Setter @Column(name = "Email")
    private String Email;
    @Getter @Setter @Column(name = "Telefono")
    private int Telefono;
    @Getter @Setter @Column(name = "Clave_acceso")
    private String Clave_acceso;
    
    public Usuario() {
    }


}
