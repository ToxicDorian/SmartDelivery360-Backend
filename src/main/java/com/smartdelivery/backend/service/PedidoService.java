package com.smartdelivery.backend.service;

import com.smartdelivery.backend.exception.EstadoPedidoInvalidoException;
import com.smartdelivery.backend.model.EstadoPedido;
import com.smartdelivery.backend.model.Pedido;
import com.smartdelivery.backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido crearPedido(Pedido pedido) {
        pedido.setEstado(EstadoPedido.CREADO);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido cambiarEstado(Long id, EstadoPedido nuevoEstado) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));

        // Regla de Negocio del PDF: ENTREGADO no puede retroceder
        if (pedido.getEstado() == EstadoPedido.ENTREGADO) {
            throw new EstadoPedidoInvalidoException("El pedido ya fue ENTREGADO y no puede modificar su estado.");
        }

        pedido.setEstado(nuevoEstado);
        return pedidoRepository.save(pedido);
    }
}