package com.secao22_266.secao22_266.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secao22_266.secao22_266.entities.User;

/*
 * Os nossos repositories eles vão ser interfaces
 * Essa interface estender o JPArepository, e ele vai te pedir o tipo da entidade e o tipo id. 
 * A minha entidade User é o tipo do id é long.
 *
 * Só isso daqui vai ser capaz instancia pra gente um objeto repository,  
 * e que vai ter várias operações pra você trabalhar com o usuário.
 * 
 * Se você criou a interface você vai ter que criar a implementação dessa interface?
 *  Nesse caso específico aqui não.
 *  
 *  Porque o Spring Data JPA, Ele já tem uma implementação padrão para essa interface.
 *  Se você definia que o JPA repositor genérico, utilizando a sua entidade e o tipo do id da sua entidade, 
 *  você já vai ter uma implementação padrão para esse tipo específico que você aqui. Então só com essa definição aqui já está pronto.
 *  
 * Você pode estar me perguntando o seguinte, o Userrepository ele também está sendo uma dependência e injetada automaticamente com @Autowired.
 * Se você voltar a lei usar repositor, eu não coloquei nada aqui no comecinho. 
 * Eu precisaria colocar aqui no comecinho o @Repository ? Poderia colocar perfeitamente. Só que não é necessário.
 * 
 * Porque a minha interface UserRepository, ela já está herdando do JPRepository, que já está registrado como um componente do Spring.
 * Então nesse caso aqui do nosso repositor que tá herdando do JPRepository é 
 * opcional você colocar aqui essa Anotation. Eu não vou colocar.

 
 */
public interface UserRepository extends JpaRepository<User, Long>{

}
