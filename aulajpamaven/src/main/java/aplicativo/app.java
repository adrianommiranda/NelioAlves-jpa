package aplicativo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class app {

	public static void main(String[] args) {
		Pessoa p = new Pessoa(null, "Adriano","adrianogmail");
		Pessoa p1 = new Pessoa(null, "Joyce","joycegmail");
		Pessoa p3 = new Pessoa(null, "marley","marleygmail");
		Pessoa p4 = new Pessoa(null, "Apagar","apagargmail");
		
		
		//Já crio a conexão com bd
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Salvando no bd
		/*em.getTransaction().begin();
		em.persist(p);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.getTransaction().commit();
		*/
		
		//Buscando pessoa no bd
		Pessoa pe = em.find(Pessoa.class, 2);
		System.out.println(pe);
		
		
		//Apagar - Primeiro pesquiso, depois apago
		/*Pessoa pe = em.find(Pessoa.class, 6);
		
		em.getTransaction().begin();
		em.remove(pe);
		em.getTransaction().commit();*/
		
		System.out.println("Pronto");
		em.close();
		emf.close();
		
		
	}

}
