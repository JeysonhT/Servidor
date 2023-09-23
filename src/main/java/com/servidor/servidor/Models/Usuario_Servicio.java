package com.servidor.servidor.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuario_Servicio")
public class Usuario_Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "Id_Usr_Service")
    private int Id_Usr_Service;

    @ManyToOne
    @JoinColumn(name = "Id_User", referencedColumnName = "Id_User")
    @Getter @Setter
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "Id_Servicios", referencedColumnName = "Id_Servicios")
    @Getter @Setter
    private Servicios servicios;

    public Usuario_Servicio() {
    }
}
