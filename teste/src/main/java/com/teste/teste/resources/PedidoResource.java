package com.teste.teste.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teste.teste.entities.Pedido;
import com.teste.teste.service.PedidoService;

@Controller
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<Pedido>> listaPedido(){
		List<Pedido> lista = pedidoService.listaPedido();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> pedidoId(@PathVariable Long id){
		Pedido pedidoIds = pedidoService.listarPorId(id);
		return ResponseEntity.ok().body(pedidoIds);
	}
}
