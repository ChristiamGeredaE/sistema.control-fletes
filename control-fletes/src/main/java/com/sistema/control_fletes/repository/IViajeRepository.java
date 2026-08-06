package com.sistema.control_fletes.repository;

import com.sistema.control_fletes.enums.EstadoViaje;
import com.sistema.control_fletes.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IViajeRepository extends JpaRepository<Viaje,Long>{
    List<Viaje> findByClienteId(Long clienteId);
    List<Viaje> findByTransporteId(Long transporteId);
    List<Viaje> findByEstado(EstadoViaje estadoViaje);
    List<Viaje> findByPilotoId(Long pilotoId);
}
