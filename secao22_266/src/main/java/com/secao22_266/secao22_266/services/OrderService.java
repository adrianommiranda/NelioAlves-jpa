package com.secao22_266.secao22_266.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secao22_266.secao22_266.entities.Order;
import com.secao22_266.secao22_266.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	}
}
