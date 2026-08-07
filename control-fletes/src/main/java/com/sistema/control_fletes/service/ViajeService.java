package com.sistema.control_fletes.service;

import com.sistema.control_fletes.model.Viaje;
import com.sistema.control_fletes.repository.IViajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService implements IViajeService {
    private final IViajeRepository viajeRepository;

    public ViajeService(IViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    public List<Viaje> verViajes() {
        return List.of();
    }

    @Override
    public List<Viaje> visualizarViajes() {
        return viajeRepository.findAll();
    }

    @Override
    public Viaje buscarViaje(Long viajeId) {
       return viajeRepository.findById(viajeId).orElse(null);
    }

    @Override
    public Viaje crearViaje(Viaje viaje) {
        return null;
    }

    @Override
    public Viaje editarViaje(Long viajeId, Viaje viaje) {
        return null;
    }

    @Override
    public boolean eliminarViaje(Long viajeId) {
        return false;
    }
}
