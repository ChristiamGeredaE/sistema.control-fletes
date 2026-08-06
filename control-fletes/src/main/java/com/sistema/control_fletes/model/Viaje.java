package com.sistema.control_fletes.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id",nullable = false)
    @JsonBackReference("cliente-viajes")
    private Cliente cliente;

    @OneToMany(mappedBy = "viaje",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pago>pagos = new ArrayList<>();

    @OneToMany(mappedBy = "viaje",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Gasto>gastos = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="transporte_id",nullable = false)
    @JsonBackReference("transporte-viajes")
    private Transporte transporte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "piloto_id", nullable = false)
    @JsonBackReference("piloto-viajes")
    private Piloto piloto;




    public Viaje(String origen, String destino, Double kilometros, LocalDateTime fecha, BigDecimal costoPorKm,Cliente cliente,Transporte transporte) {
        this.origen = origen;
        this.destino = destino;
        this.kilometros = kilometros;
        this.fecha = fecha;
        this.costoPorKm = costoPorKm;
        this.estado= EstadoViaje.PENDIENTE;
        this.cliente=cliente;
        this.transporte = transporte;

    }
}
