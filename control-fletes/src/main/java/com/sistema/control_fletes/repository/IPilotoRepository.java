package com.sistema.control_fletes.repository;

import com.sistema.control_fletes.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPilotoRepository extends JpaRepository<Piloto,Long> {

}
