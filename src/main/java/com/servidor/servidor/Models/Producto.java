package com.servidor.servidor.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Producto")
@Getter @Setter
public class Producto {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_producto")
    private int Id_producto;

    @Column(name = "Nombre")
    private String Nombre; 

    @Column(name = "Marca")
    private String Marca;

    @Column(name = "Numero_parte")
    private String Numero_parte;

    @Column(name = "Categoria")
    private String Categoria;

    @Column(name = "Costo")
    private float Costo;

    @Column(name = "Cantidad_Stock")
    private int Cantidad_stock;

    @Column(name = "anio_fabricacion")
    private int anio_fabricacion;

    @Column(name = "Modelo_auto")
    private String Modelo_auto;

    @ManyToOne
    @JoinColumn(name = "Id_afiliado", referencedColumnName = "Id_afiliado")
    private Afiliados afiliados;

    
    public Producto(int id_producto, String nombre, String marca, String numero_parte, String categoria, float costo,
            int cantidad_stock, int anio_fabricacion, String modelo_auto, Afiliados afiliados) {
        Id_producto = id_producto;
        Nombre = nombre;
        Marca = marca;
        Numero_parte = numero_parte;
        Categoria = categoria;
        Costo = costo;
        Cantidad_stock = cantidad_stock;
        this.anio_fabricacion = anio_fabricacion;
        Modelo_auto = modelo_auto;
        this.afiliados = afiliados;
    }

    
    public Producto(int id_producto, String nombre, String marca, String categoria, float costo, int cantidad_stock,
            String modelo_auto, Afiliados afiliados) {
        Id_producto = id_producto;
        Nombre = nombre;
        Marca = marca;
        Categoria = categoria;
        Costo = costo;
        Cantidad_stock = cantidad_stock;
        Modelo_auto = modelo_auto;
        this.afiliados = afiliados;
    }


    public Producto() {
    }

    

}
