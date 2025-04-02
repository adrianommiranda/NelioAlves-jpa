package com.teste.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.teste.entities.Pedido;
import com.teste.teste.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> listaPedido(){
		return pedidoRepository.findAll();
	}
	
	public Pedido listarPorId(Long id) {
		Optional<Pedido> pedidoId = pedidoRepository.findById(id);
		return pedidoId.get();
	}
}
