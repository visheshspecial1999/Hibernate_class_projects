package com.jsp.many_to_many_bidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.many_to_many_bidirection.dto.Customer;

public class CustomerDao {
	EntityManager entityManager=Persistence.createEntityManagerFactory("vishesh").createEntityManager();
	
	// insertCustomer method
	public void insertCustomer(Customer customer) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		System.out.println("data inserted");
	}
	
	// searchCustomer method
	public Customer searchCustomer(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}
	
	// updateCustomer method
	public void updateCustomer(Customer customer) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
		System.out.println("data updated");
	}
	
	// deleteCustomer method
	public void deleteCustomer(int customerId) {
		Customer customer=entityManager.find(Customer.class, customerId);
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(customer);
		entityTransaction.commit();
		System.out.println("data deleted");
	}
	
	// displayCustomer method
	public List<Customer> displayCustomer() {
	String st="select c from Customer c";
	Query query=entityManager.createQuery(st);
	return query.getResultList();
	}
	
}
