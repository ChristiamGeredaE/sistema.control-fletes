package com.sistema.control_fletes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sistema.control_fletes.enums.MetodoDePago;
import com.sistema.control_fletes.enums.TipoPago;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name ="monto",precision = 10,scale = 2,nullable = false)
    private BigDecimal monto;

    @Column (name ="fecha",nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(name="metodo_pago",nullable = false)
    private MetodoDePago metodoDePago;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_pago",nullable = false)
    private TipoPago tipoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="viaje_id",nullable = false)
    @JsonBackReference
    private Viaje viaje;

    public Pago( BigDecimal monto, LocalDateTime fecha, MetodoDePago metodoDePago, TipoPago tipoPago,Viaje viaje) {
        this.monto = monto;
        this.fecha = fecha;
        this.metodoDePago = metodoDePago;
        this.tipoPago = tipoPago;
        this.viaje = viaje;

    }
}
