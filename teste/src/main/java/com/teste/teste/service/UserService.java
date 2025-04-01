package com.teste.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.teste.entities.User;
import com.teste.teste.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> listaTodos(){
		return repository.findAll();
	}
	
	public User listaId(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
