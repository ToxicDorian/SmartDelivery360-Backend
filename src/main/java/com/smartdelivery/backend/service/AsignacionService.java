package com.smartdelivery.backend.service;

import com.smartdelivery.backend.model.Pedido;
import com.smartdelivery.backend.model.Repartidor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AsignacionService {

    // Lista simulada en memoria mientras se mapean en BD
    private final List<Repartidor> repartidoresDisponibles = new ArrayList<>();

    public AsignacionService() {
        // Repartidores de prueba
        repartidoresDisponibles.add(new com.smartdelivery.backend.model.RepartidorMoto(1L, "Carlos Gómez"));
        repartidoresDisponibles.add(new com.smartdelivery.backend.model.RepartidorVehiculo(2L, "María Rodríguez"));
    }

    public Optional<Repartidor> asignarRepartidorAPedido(Pedido pedido, double distanciaKm) {
        // Busca el primer repartidor disponible
        Optional<Repartidor> asignado = repartidoresDisponibles.stream()
                .filter(Repartidor::isDisponible)
                .findFirst();

        asignado.ifPresent(repartidor -> {
            repartidor.setDisponible(false); // Cambia estado a ocupado
            double tiempoEstimado = repartidor.calcularTiempoEstimadoEntrega(distanciaKm);
            System.out.println("Pedido " + pedido.getId() + " asignado a " + repartidor.getNombre() 
                    + ". Tiempo estimado: " + Math.round(tiempoEstimado) + " mins.");
        });

        return asignado;
    }

    public List<Repartidor> obtenerTodosLosRepartidores() {
        return repartidoresDisponibles;
    }
}