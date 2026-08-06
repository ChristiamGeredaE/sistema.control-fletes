package com.sistema.control_fletes.repository;

import com.sistema.control_fletes.model.Gasto;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IGASTOREPOSITORY extends JpaRepository<Gasto,Long> {
    List<Gasto> findByViajeId (Long viajeId);
    List<Gasto> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);

}
