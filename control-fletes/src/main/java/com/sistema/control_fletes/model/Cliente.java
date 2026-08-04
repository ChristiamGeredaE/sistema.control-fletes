package com.sistema.control_fletes.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clientes")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="nombre",nullable = false,length = 255)
    private String nombre;
    
    @Column(name = "telefono",nullable = false,length = 14)
    private String telefono;
    
    @Column(name ="nit",length = 15)
    private String nit;
    
    @Column(name="direccion",length = 100)
    private String direccion;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
    @JsonManagedReference("cliente-viajes")
    private List<Viaje>viajes = new ArrayList<>();

    public Cliente(String nombre, String telefono, String nit, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.nit = nit;
        this.direccion = direccion;
    }
}
