package com.teste.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.teste.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
