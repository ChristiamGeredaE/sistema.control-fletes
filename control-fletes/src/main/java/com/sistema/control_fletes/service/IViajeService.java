package com.sistema.control_fletes.service;

import com.sistema.control_fletes.model.Viaje;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IViajeService {

    List<Viaje>verViajes ();
    Viaje buscarViaje(Long id);

    Viaje crearViaje (Viaje viaje);

    Viaje editarViaje(Long viajeId,Viaje viaje);

    boolean eliminarViaje(Long viajeId);
}
