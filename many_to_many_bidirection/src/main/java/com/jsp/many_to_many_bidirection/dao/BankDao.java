package com.jsp.many_to_many_bidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.many_to_many_bidirection.dto.Bank;

public class BankDao {
	EntityManager entityManager=Persistence.createEntityManagerFactory("vishesh").createEntityManager();
	
	// insertBank method
	public void insertBank(Bank bank) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
		System.out.println("data inserted");
	}
	
	// searchBank method
	public Bank searchBank(int bankId) {
		return entityManager.find(Bank.class, bankId);
	}
	
	// updateBank method
	public void updateBank(Bank bank) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(bank);
		entityTransaction.commit();
		System.out.println("data updated");
	}
	
	// deleteBank method
	public void deleteBank(int bankId) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank bank=entityManager.find(Bank.class, bankId);
		entityTransaction.begin();
		entityManager.remove(bank);
		entityTransaction.commit();
		System.out.println("data deleted");
	}
	
	// displayBank method
	public List<Bank> displayBank(){
		String st="Select c from Bank c";
		Query query=entityManager.createQuery(st);
		return query.getResultList();
	}

}
