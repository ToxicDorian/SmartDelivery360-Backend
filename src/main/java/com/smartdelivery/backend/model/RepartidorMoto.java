package com.smartdelivery.backend.model;

public class RepartidorMoto extends Repartidor {
    public RepartidorMoto(Long id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double calcularTiempoEstimadoEntrega(double distanciaKm) {
        return (distanciaKm / 40.0) * 60; // 40 km/h promedio
    }
}
