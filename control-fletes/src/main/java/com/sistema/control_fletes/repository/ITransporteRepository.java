package com.sistema.control_fletes.repository;

import com.sistema.control_fletes.model.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ITransporteRepository extends JpaRepository<Transporte,Long> {

}
