package com.example.demo_agro.entity;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "insumos")
public class Insumos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int cantidad;
    private boolean medirKg;
    public void usarInsumo(int cantidad){
        if(this.cantidad>=cantidad)
            this.cantidad -= cantidad;
        else
            System.out.println("Cantidad superior a la cantidad almacenada");
    }
    public void agregarInsumo(int cantidad) {
        this.cantidad += cantidad;
    }

    public void mostrarCantidad() {
        System.out.print("Cantidad: " + cantidad);
        if(medirKg)
            System.out.println("Kg");
        else
            System.out.println("L");
    }
}
