package com.secao22_266.secao22_266.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secao22_266.secao22_266.entities.Order;
import com.secao22_266.secao22_266.services.OrderService;

@Controller
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> listOrder = orderService.findAll();
		return ResponseEntity.ok().body(listOrder);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = orderService.findById(id);
		return ResponseEntity.ok().body(obj);
	} 
}
