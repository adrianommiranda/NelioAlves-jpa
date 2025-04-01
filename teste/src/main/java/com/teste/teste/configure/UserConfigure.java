package com.teste.teste.configure;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.teste.teste.entities.Pedido;
import com.teste.teste.entities.User;
import com.teste.teste.repositories.PedidoRepository;
import com.teste.teste.repositories.UserRepository;

@Configuration
@Profile("test")
public class UserConfigure implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown"); 
		User u2 = new User(null, "Alex Green"); 
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
