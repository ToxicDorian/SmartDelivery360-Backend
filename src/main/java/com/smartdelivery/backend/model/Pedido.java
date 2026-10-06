package com.smartdelivery.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String comercio;
    private Double total;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    public Pedido() {
        this.estado = EstadoPedido.CREADO;
    }

    public Pedido(String cliente, String comercio, Double total) {
        this.cliente = cliente;
        this.comercio = comercio;
        this.total = total;
        this.estado = EstadoPedido.CREADO;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getComercio() { return comercio; }
    public void setComercio(String comercio) { this.comercio = comercio; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido estado) { this.estado = estado; }
}
