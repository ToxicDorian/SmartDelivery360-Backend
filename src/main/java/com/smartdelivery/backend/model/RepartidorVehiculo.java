package com.smartdelivery.backend.model;

public class RepartidorVehiculo extends Repartidor {

    public RepartidorVehiculo(Long id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double calcularTiempoEstimadoEntrega(double distanciaKm) {
        // Promedio de 25 km/h en ciudad por tráfico de vehículos
        return (distanciaKm / 25.0) * 60;
    }
}