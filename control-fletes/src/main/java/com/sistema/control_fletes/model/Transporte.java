package com.sistema.control_fletes.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="transportes")
@Getter
@Setter
@NoArgsConstructor
public class Transporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="placa",nullable = false,length = 25)
    private String placa;

    @Column(name="marca",nullable = false,length = 20)
    private String marca;

    @Column(name="modelo",nullable = false)
    private int modelo;

    @OneToMany(mappedBy = "transporte" ,fetch = FetchType.LAZY)
    @JsonManagedReference("transporte-viajes")
    private List<Viaje> viajes = new ArrayList<>();

    public Transporte(String placa, String marca, int modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }
}
