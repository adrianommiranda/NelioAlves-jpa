package com.secao22_266.secao22_266.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.secao22_266.secao22_266.entities.Category;
import com.secao22_266.secao22_266.entities.Order;
import com.secao22_266.secao22_266.entities.User;
import com.secao22_266.secao22_266.entities.enums.OrderStatus;
import com.secao22_266.secao22_266.repositories.CategoryRepository;
import com.secao22_266.secao22_266.repositories.OrderRepository;
import com.secao22_266.secao22_266.repositories.UserRepository;

/*
 * Agora a gente vai criar um pacote .config e uma classe de configuração. 
 * Classe de configuração, ela não é nem Controller nem service e nem repository.
 * Ela vai ser uma classe auxiliar que vai fazer algumas configurações na minha aplicação. 
 * Isso é uma prática muito utilizada.
 *
 *
 * Pra falar pro Spring, que essa aqui é uma classe específica de configuração,
 * a gente vai colocar aqui no comecinho dela uma anotation @Configuration
 * 
 * Pra falar que essa classe ela vai ser uma configuração, 
 * específica para o perfil de teste, eu vou ter que colocar aqui também uma outra anotation, @Profile(“test”) 
 * Eu vou abrir parênteses e colocar entre aspas a palavrinha test.
 * Esse nome test tem que ser igualzinho esse nome test 
 * que você colocou aqui no profile do aprlication.propeties
 * 
 * 
 * Aí o Spring consegue identificar que ele vai rodar essa configuração, somente quando você tiver no perfil de teste.
 * Essa classe de configuração, ela vai servi por enquanto pra, 
 * pra gente fazer o nosso database seeding, 
 * ou seja é pra popular o nosso banco de dados com alguns objetos.
 * 
 * 
 * Pra você fazer o objeto depender de outro você tem que declarar essa dependência.
 * Um atributo do tipo UserRepository
 * Para que o Spring consiga resolver essa dependência e e associar uma instância do UserRepository no meu TestConfigure.
 * Basta colocar em cima do atributo o anotation - @Autowired
 * 
 *  
 *  como o que eu vou fazer para executar isso quando o programa foi iniciado? 
 *  Tem algumas formas de fazer isso aqui no Spring.
 *  Eu vou fazer aqui usando um macete de colocar minha classe implementando 
 *  uma interface chamada implements CommandLineRunner
 *  Vou implementar
 *  
 *  O método é p run
 *  Tudo o que você colocar aqui dentro desse método vai 
 *  ser executado quando a aplicação for iniciada.
 *  Vou instanciar os usuários
 *  
 *  Agora eu vou salvar esses dois usuários o 1 e o 2 no meu banco de dados.
 *  Pra salvar eu vou chamar o meu e UserRepository,  
 *  que é o meu objeto repositor que acessa os dados.
 *  
 *  Então chamar o meu userRepository.saveAll, 
 *  e a partir dele eu vou chamar o saveall 
 *  e eu vou passar uma lista de objetos, 
 *  e ele salva essa lista no banco de dados.
 *  
 *  Vou chamar a lista e dentro dela, passar o objeto 1 e o 2
 *  
 *  Só isso daqui então a nossa classe de configuração pra ele instancia o banco de dados pra gente
 * 
 */

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		//Fazendo seed
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}

}
