package com.secao22_266.secao22_266.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/*
 * palavra user é uma palavra reservada do banco de dados H2
 * Então é importante que a gente renomeie para essa tabela para 
 * não dar conflito com a palavra user do banco
 * 
 * name = "tb_user"
 * 
 * */
@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	
	/*
	 * Associalção tabela pedidos(Order)
	 * 
	 * Só que aí pessoal se você reparar aqui ou no check list 
	 * de entidade nós temos que instanciar as coleções. 
	 * Então aqui no caso, como a lista de pedidos do usuário ela é uma coleção, 
	 * na frente dela que eu já vou instanciar.
	 * 
	 * Agora vamos acrescentar o método get para esta Lista
	 * No caso de uma coleção, só colocamos o get. 
	 * Não colocamos os set, porque não vamos trocar a lista.
	 * 
	 * 
	 * Já do lado do um para muitos a gente pode mapear também no JPA.
	 * É opcional, mas caso você queira acessar, um objeto do tipo usuário, e
	 *  acessar automaticamente os pedidos feitos por esse usuário, você pode também mapear do lado do um para muitos.
	 *  
	 *  Vamos fazer isso então.  Vamos na classe usuário.
	 *  Aqui na minha lista de pedidos eu vou colocar o seguinte @OneToMany .
	 *  e entre parênteses eu vou ter que colocar o nome do atributo que tem lá do outro lado da associação.
	 *  Ora quem que é o atributo do outro lado da associação é esse que tá aqui na classe ordem client
	 *  
	 *  Na classe user, eu vou falar o seguinte, esse muitos para um, 
	 *  lado ou outro lado ele está mapeado por quem, mapeado pelo atributo cliente.
	 *  @OneToMany(mappedBy = "client")


	 */
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	//Como estamos usando um framework, será obrigado a colocar vazio
	public User() {}


	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Order> getOrders() {
		return orders;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	


	
	
	
}
