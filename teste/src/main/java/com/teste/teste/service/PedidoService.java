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
	
	public List<Pedido> listarPedidos(){
		return pedidoRepository.findAll();
	}
	
	public Pedido pedidoId(Long id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.get();
	}
}
