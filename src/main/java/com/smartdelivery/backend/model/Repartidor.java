package com.smartdelivery.backend.model;

import com.smartdelivery.backend.interfaces.Calificable;
import com.smartdelivery.backend.interfaces.Rastreable;

public abstract class Repartidor implements Rastreable, Calificable {
    private Long id;
    private String nombre;
    private boolean disponible;
    private double promedioCalificacion;

    public Repartidor(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.disponible = true;
        this.promedioCalificacion = 5.0;
    }

    public abstract double calcularTiempoEstimadoEntrega(double distanciaKm);

    @Override
    public String obtenerUbicacionActual() {
        return "Ubicacion GPS simulada de " + nombre;
    }

    @Override
    public void agregarCalificacion(double puntuacion) {
        this.promedioCalificacion = (this.promedioCalificacion + puntuacion) / 2;
    }

    @Override
    public double obtenerPromedioCalificacion() {
        return promedioCalificacion;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}