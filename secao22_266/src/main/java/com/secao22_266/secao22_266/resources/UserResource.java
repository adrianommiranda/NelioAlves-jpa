package com.secao22_266.secao22_266.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secao22_266.secao22_266.entities.User;
import com.secao22_266.secao22_266.services.UserService;

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
	 * return ResponseEntity.ok().body(u); - retornar o corpo da resposta, este meu User u acabei de instanciar
	 * 
	 * Eu vou apagar essa instância ação manual que eu tinha feito eu vou
	 * fazer uma declaração de uma lista de usuario. Vou dar o nome de list 
	 * recebendo o serviço na operação findAll(); 
	 * Então olha só aqui no comecinho do Resource,  
	 * eu vou colocar uma dependência para o Service.
	 * 
	 * Nós iríamos aprender aqui o componet registration. 
	 * É porque quando você tem um objeto que ele vai poder ser 
	 * injetado pelo mecanismo de injeção de dependência do Spring,  
	 * a classe desse seu objeto ela tem que estar registrada
	 * no mecanismo de gestão de dependência.
	 * 
	 * Todo framework que você for usar seja front ou back,  
	 * ele vai ter alguma forma de você registrar algum serviço ou 
	 * alguma classe no mecanismo de gestão de dependência.
	 * 
	 * Então aqui por exemplo eu tenho o meu e UserResource que depende do UserService.
	 * 
	 * Esse UserService, ele vai ser injetado aqui automaticamente porque eu coloquei o @Autowired 
	 * Só que pra isso aqui funcionar a minha classe UserService, ela tem que estar registrada como um componente do Spring.
	 * Então eu vou ter que voltar aqui na minha classe UserService e registra-la como um componente. Como eu posso fazer isso? 
	 * 
	 * 
	 * Vou no meu UserResource, e vou implementar endPoint para buscar usuário por id Vamos colocar o @GetMapping - 
	 * porque também vai ser uma requisição do tipo Get. 
	 * Só que nesse caso, eu vou passar não URL, o valor do id do usuário. 
	 * Pra falar a minha URL vai ter um parâmetro também, @GetMapping(value = "/{id}")
	 * Isso aqui vai indicar que a minha requisição vai aceitar um id, dentro da URL.
	 * 
	 * Vamos declarar o nosso método.vai ser do tipo ResponseEntity do tipo User, 
	 * porque agora vai retornar apenas um usuário e eu vou dar o nome aqui findById()
	 * Só que esse findById()  agora vai receber esse parâmetro da URL.
	 * 
	 * Então pra receber isso aqui dentro endPoint do controlador Rest, 
	 * eu tenho que declarar aqui um argumento que seria o Long id.
	 * Só que para o Spring aceitar esse id, e considerá lo como o parâmetro que vai chegar aqui da URL, 
	 * eu tenho que colocar aqui na frente um anotei @PathVariable
	 * User obj = service.findById(id); repassando o id que chegou na requisição.
	 * Feito isso eu vou mandar o meu método retornar o return ResponseEntity.ok().body(obj);
	 * Então esse aqui é o nosso endPoit.
	 * 
	 */
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		//User u = new User(1L, "Adriano", "adriano@gmail", "777777", "123");
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
