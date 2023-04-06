package com.jsp.one_to_one_uni_direction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.one_to_one_uni_direction.dto.Passport;
import com.jsp.one_to_one_uni_direction.dto.Person;

public class PersonDao {

	// savePassportPerson method
	public void savePassportPerson(Passport passport, Person person) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishesh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(passport);
		entityManager.persist(person);
		entityTransaction.commit();

	}

	// getByIdPerson method
	public Person getByIdPerson(int personId) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("vishesh").createEntityManager();

		Person person = entityManager.find(Person.class, personId);
		if (person != null) {
			return person;
		} else {
			return null;
		}

	}

	// updatePassportPerson method
	public void updatePassportPerson(Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vishesh");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(person);
		entityManager.merge(person.getPassport());
		entityTransaction.commit();
		
	}
	
	// deletePassportPerson method
	public void deletePassportPerson(int personId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishesh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, personId);
		if (person != null) {
			Passport passport = person.getPassport();
			entityTransaction.begin();
			entityManager.remove(person);
			entityManager.remove(passport);
			entityTransaction.commit();
		}
	}
	
	// display method
	public List<Person> display(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishesh");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String st="SELECT c FROM Person c";
		Query query=entityManager.createQuery(st);
//		 List<Person>list=query.getResultList();
//		 return list;
		return query.getResultList() ;
//		 return entityManager.createQuery(query).getResultList();
	}
	
	// display method 2
	public List<Person>getAllPersonPassport(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vishesh");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String displayQuery="SELECT p FROM Person p";
		Query query=entityManager.createQuery(displayQuery);
		return query.getResultList();
	}
	
	/*
	 * update by method overloading
	 */
	// updatePersonPassport
	public void updatePersonPassport(int personId,String PersonName,String passportType)
	{
		EntityManager entityManager=Persistence.createEntityManagerFactory("vishesh").createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=getByIdPerson(personId);
		if(person!=null)
		{
			Passport passport=person.getPassport();
			if(passport!=null)
			{
				passport.setPassportType(passportType);
			}
			person.setPersonName(PersonName);
			entityTransaction.begin();
			entityManager.merge(person);
			entityManager.merge(passport);
			entityTransaction.commit();
		}
	}
}
