package com.sistema.control_fletes.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sistema.control_fletes.enums.EstadoViaje;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table  (name="viajes")
@Getter
@Setter
@NoArgsConstructor

public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origen",nullable = false,length = 255)
    private String origen;

    @Column(name ="destino",nullable = false,length = 255)
    private String destino;

    @Column(name="kilometros",nullable = false)
    private Double kilometros;

    @Column(name = "fecha",nullable = false)
    private LocalDateTime fecha;

    @Column(name = "costo_por_km",precision =10,scale = 2,nullable = false)
    private BigDecimal costoPorKm;

    @Column(name="monto_total",precision =12,scale = 2,nullable = false )
    private BigDecimal montoTotal ;

    @Enumerated(EnumType.STRING)
    @Column(name= "estado",nullable = false)
    private EstadoViaje estado;

    public Viaje(String origen, String destino, Double kilometros, LocalDateTime fecha, BigDecimal costoPorKm) {
        this.origen = origen;
        this.destino = destino;
        this.kilometros = kilometros;
        this.fecha = fecha;
        this.costoPorKm = costoPorKm;
        this.estado= EstadoViaje.PENDIENTE;

    }
}
