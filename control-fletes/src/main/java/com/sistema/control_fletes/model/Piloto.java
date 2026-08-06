package com.sistema.control_fletes.model;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="pilotos")
@Getter
@Setter
@NoArgsConstructor

public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false,length = 80)
    private String nombre;

    @Column(name ="apellido",nullable = false,length = 80)
    private String apellido;

    @Column(name = "doc_identidad",nullable = false,length = 15)
    private String dpi;

    @OneToMany(mappedBy = "piloto" ,fetch = FetchType.LAZY)
    @JsonManagedReference("piloto-viajes")
    private List<Viaje> viajes = new ArrayList<>();
}
