package com.teste.teste.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teste.teste.entities.User;
import com.teste.teste.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserResourse {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> listar(){
		List<User> lista = userService.listaTodos();
		return ResponseEntity.ok().body(lista);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> userId(@PathVariable Long id){
		User obj = userService.listaId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
