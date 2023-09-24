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
@Table(name = "Usuario_Vehi")
public class Usuario {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Getter @Setter @Column(name = "Id_User")
    private int Id_User;

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
    @Getter @Setter @Column(name = "Num_celular")
    private int Num_celular;
    @Getter @Setter @Column(name = "Password")
    private String Password;
    
    public Usuario() {
    }


}
