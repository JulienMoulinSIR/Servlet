package Jpa;

import java.util.List;

import javax.persistence.*;

import opower.Person;

public class Jpa {

	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction tx;

	public Jpa(String bdd) {
		factory = Persistence.createEntityManagerFactory(bdd);
		manager = factory.createEntityManager();
		tx = manager.getTransaction();
	}
	
	public void persistData(Object o){
		tx.begin();
		manager.persist(o);
		tx.commit();
	}
	
	public List<Person> getPersons(){
		 return manager.createQuery("SELECT a FROM Person a ", Person.class).getResultList();
	}
	

}
