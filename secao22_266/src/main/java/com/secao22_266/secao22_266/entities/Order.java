package com.secao22_266.secao22_266.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//iso 8601
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT" )
	private Instant moment;
	
	/*
	 * Associalção tabela cliente
	 * 
	 * Precisamos entender bem o que está acontecendo. 
	 * Eu tenho aqui uma associação muitos para um (n - 1) entre pedido e usuário.
	 * O pedido é ao lado do muitos e o usuário é ao lado do 1. 
	 * Então, no caso aqui eu estando na classe pedido, 
	 * eu tenho uma associação muitos para um (n - 1)  com o meu usuário. 
	 * Então pra eu instruiu meu JPA, para transformar isso aqui numa chave estrangeira, 
	 * eu vou ter que colocar aqui a anotation
	 * @ManyToOne
	 * private User client; 
	 * Além disso eu vou completar aqui com uma outra anotation do JPA,  
	 * @JoinColumn
	 * 
	 * @JoinColumn  e entre parênteses, 
	 * eu vou falar qual é o nome da chave estrangeira que vai ter lá no banco de dados. 
	 * Eu vou colocar aqui
	 * Então o parâmetro name =  dar um nome pra essa chave estrangeira aqui. Eu vou dar o nome de client_id.
	 * 
	 */
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	public Order() {}
	
	public Order(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
