package com.smartdelivery.backend.exception;

public class EstadoPedidoInvalidoException extends RuntimeException {
    public EstadoPedidoInvalidoException(String mensaje) {
        super(mensaje);
    }
}