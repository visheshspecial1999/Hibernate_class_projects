package com.jsp.one_to_one_bidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.one_to_one_bidirection.dto.Laptop;

public class LaptopDao {
	
	EntityManager entityManager=Persistence.createEntityManagerFactory("vishesh").createEntityManager();
	
	// saveLaptop method
	public void saveLaptop(Laptop laptop) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(laptop);
		entityTransaction.commit();
		System.out.println("data inserted");
	}
	
	// searchLaptop method
	public Laptop searchLaptop(int laptopId) {
	Laptop laptop	=entityManager.find(Laptop.class, laptopId);
	return laptop;
	}
	
	// updateLaptop method
	public void updateLaptop(Laptop laptop) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(laptop);
		entityTransaction.commit();
		System.out.println("data updated");	
	}
	
	// deleteLaptop method
	public void deleteLaptop(int laptopId) {
		Laptop laptop=entityManager.find(Laptop.class, laptopId);
		if(laptop!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(laptop);
		entityTransaction.commit();
		System.out.println("data deleted");
		}
		else {
			System.out.println("laptopId not found in database or already has been deleted");
		}
	}
	
	// displayLaptop method
	public List<Laptop> dispalyAllLaptop(){
		String st="SELECT c FROM Laptop c";
		Query query=entityManager.createQuery(st);
		return query.getResultList();
	}
	
}
