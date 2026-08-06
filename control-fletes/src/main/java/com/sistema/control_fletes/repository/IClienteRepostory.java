package com.sistema.control_fletes.repository;

import com.sistema.control_fletes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClienteRepostory extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByNombre(String nombre);
}
