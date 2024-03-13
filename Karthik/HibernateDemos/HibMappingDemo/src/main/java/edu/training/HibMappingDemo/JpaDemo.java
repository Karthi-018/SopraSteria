package edu.training.HibMappingDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDemo {
	 
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Student s = (Student)em.find(Student.class, 101);
		em.getTransaction().commit();
		System.out.println(s);
	}

}
