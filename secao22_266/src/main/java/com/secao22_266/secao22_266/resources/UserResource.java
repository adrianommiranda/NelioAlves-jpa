package com.secao22_266.secao22_266.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secao22_266.secao22_266.entities.User;

/*
 *Essa classe vai disponibilizar para mim um recurso web correspondente a entidade User
 * 
 * A anotation - @RestController - 
 * 
 * Vou dar o nome do meu recurso - @RequestMapping(value = "/users") - entre aspas, o caminho do meu recurso,
 * no caso é um recurso relacionado com a entidade User vai se chamar /users
 * 
 *  Este é o nosso controlador rest, que responde no caminho /users
 */

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	/*
	 *
	 *Vai ter um anotation - @GetMapping - para informar que este método, 
	 *vai ser um método que responde a requisição do tipo Get do http,
	 *vou colocar um anotatio chamado de @GetMapping
	 *
	 *vamos fazer um teste
	 *Vou criar um método que vai ser um end point para acessar aos usuários
	 * 
	 * Tipo de retorno vai ser do tipo ResponseEntity, 
	 * que é um tipo específico do spring, para retornar respostas de requisição web
	 * 
	 * ResponseEntity é um genérico e ele espera um tipo, que vai ser a minha classe User
	 * Vou dar um nome para meu método - listar
	 * 
	 * Istanciar o meu user
	 * 
	 * Retornar ResponseEntity.ok - para retornar a resposta com sucesso
	 * return ResponseEntity.ok().body(u); - retornar o curpo da resposta, este meu User u acabei de instanciar
	 * 
	 *
	 */
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Adriano", "adriano@gmail", "777777", "123");
		return ResponseEntity.ok().body(u);
	}
}
