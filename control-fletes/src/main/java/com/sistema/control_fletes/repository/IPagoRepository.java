package com.sistema.control_fletes.repository;

import com.sistema.control_fletes.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPagoRepository extends JpaRepository<Pago,Long> {
    List<Pago> findByViajeId(Long viajeId);
    List<Pago> findByFechaBetween(LocalDateTime inicio,LocalDateTime fin);

}
