package com.sistema.control_fletes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sistema.control_fletes.enums.TipoGasto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (name="gastos")
@Getter
@Setter
@NoArgsConstructor

public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="viaje_id",nullable = false)
    @JsonBackReference
    private Viaje viaje;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_gasto",nullable = false)
    private TipoGasto tipoGasto;

    @Column(name="monto",precision = 12,scale = 2, nullable = false)
    private BigDecimal monto;

    @Column(name="fecha",nullable = false)
    private LocalDateTime fecha;

    @Column(name="descripcion",length = 255)
    private String descripcion;

    public Gasto(TipoGasto tipoGasto, BigDecimal monto, LocalDateTime fecha, String descripcion, Viaje viaje) {
        this.tipoGasto = tipoGasto;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.viaje = viaje;
    }
}
