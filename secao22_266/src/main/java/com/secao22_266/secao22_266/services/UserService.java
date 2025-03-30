package com.secao22_266.secao22_266.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.secao22_266.secao22_266.entities.User;
import com.secao22_266.secao22_266.repositories.UserRepository;
/*
 * Eu vou implementar duas operações básicas. Operação para buscar todos os usuários e operação para buscar o usuário por id.
 * Pra fazer isso, o meu UserService, vai ter que ter uma dependência para o UserRepository. 
 * Então vou declarar dependesse.
 * 
 * Aí eu vou dar o nome de private UserRepository repository;
 * Vou colocar já aqui no comecinho o @Autowired para que o Spring 
 * faça essa injeção de dependência que de forma transparente ao programador.
 * 
 * E agora eu vou criar um método para retornar todos os usuários do banco de dados. 
 * Então vai método publico lista(do tipo e User) e eu vou dar o nome do método que findAll.
 * Nesse método aqui vai mandar retornar o repositor e ponto. tenho várias operações aqui no repositório vamos colocar findAll();
 * 
 * Fizemos aqui uma operação na camada de serviço que é o findAll(),  
 * ela repassa a chamada para o repositor.findall(); 
 * Lá no meu UserResouce, que é o Controladorrest,  eu vou atualizar aqui a implementação do meu findAll()
 * 
 * O Spring ele tem algumas anotatios  @Component  
 * Ela já registra pra você a sua classe como um componente do Spring, 
 * e ele vai poder ser injetado assim automaticamente com o @Autowired
 * 
 * Só que também o spring,  além do @Component  ele tem algumas outras anotations que tem uma semântica mais específica para que você precisar.
 * Por exemplo: @Repository - pra você registrar um repositor, se você precisar e também ela tem o @Service -
 *  que é pra você registrar um serviço na sua camada de serviço.
 *  
 *  Então como a minha classe é uma classe de serviço, eu vou dar preferência ao @Service, 
 *  só pra ficar mais semanticamente específico.
 *  
 *  O service já registrado como componente, tem a injeção de
 *  dependência aqui do Repository @Autowired, 
 *  e por sua vez o UserResouce que é um RestController, ele tem a dependência do Service.
 *  
 *  
 *  Vamos só fazer mais um endPoint, pra buscar o usuário por id.
 *  Eu vou começar pelo UserService. Eu vou acrescentar aqui ou uma outra Operação.
 *  Eu vou cria um método recebendo id. 
 *  Para recuperar o usuário por id,  eu vou chamar o meu repository.findById(id); 
 *  Essa operação aqui na verdade ela vai retornar pra mim um objeto opcional, Opcional do tipo User.  
 *  Optional<User> repository.findById(id); Ele existe desde o Java 8. 
 *  Vou colocar obj como o nome da variável, vou importar. 
 *  Vou mandar o meu método retornar o meu obj,get();
 *  A operação gera do option , ela vai retornar o objeto tipo User , que estiver dentro do meu optional. 






 * 
 * 
 * */
//@Component
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
