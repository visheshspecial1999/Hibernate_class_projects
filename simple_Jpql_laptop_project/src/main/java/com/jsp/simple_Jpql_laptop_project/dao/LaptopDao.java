package com.jsp.simple_Jpql_laptop_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.simple_Jpql_laptop_project.dto.Laptop;

public class LaptopDao {
	EntityManager entityManager = Persistence.createEntityManagerFactory("vishesh").createEntityManager();

	// insertLaptop method
	public int insertLaptop(Laptop laptop) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String insertQuery = "INSERT INTO Laptop(laptopId,laptopName,laptopPrice) VALUES(?,?,?)";
		Query query = entityManager.createNativeQuery(insertQuery);
		query.setParameter(1, laptop.getLaptopId());
		query.setParameter(2, laptop.getLaptopName());
		query.setParameter(3, laptop.getLaptopPrice());
		entityTransaction.begin();
		int feedback = query.executeUpdate();
		entityTransaction.commit();
		return feedback;
	}

	// getByLaptopId method
	public Laptop getByLaptopId(int laptopId) {
		String getByIdQuery = "SELECT L FROM Laptop L WHERE L.laptopId=:eid";
		Query query = entityManager.createQuery(getByIdQuery);
		if (query != null) {
			query.setParameter("eid", laptopId);
			Object object = query.getSingleResult();

			Laptop laptop = (Laptop) object;
			return laptop;
		} else {
			return null;
		}
	}

	// updateLaptop method
	public int updateLaptop(Laptop laptop) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String updateQuery = "UPDATE Laptop L SET L.laptopName=:lname,L.laptopPrice=:lprice WHERE L.laptopId=:eId";
		Query query = entityManager.createNativeQuery(updateQuery);

		query.setParameter("eId", laptop.getLaptopId());
		query.setParameter("lname", laptop.getLaptopName());
		query.setParameter("lprice", laptop.getLaptopPrice());

		entityTransaction.begin();
		int feedback = query.executeUpdate();
		entityTransaction.commit();
		return feedback;
	}

	// deleteLaptop method
	public int deleteLaptop(int laptopId) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String deleteQuery = "DELETE FROM Laptop L WHERE L.laptopId=:eId";
		Query query = entityManager.createQuery(deleteQuery);
		query.setParameter("eId", laptopId);
		entityTransaction.begin();
		int feedback = query.executeUpdate();
		entityTransaction.commit();
		return feedback;

	}

	// displayLaptop method
	public List<Laptop> displayLaptop() {
		String select = "SELECT a FROM Laptop a";
		Query query = entityManager.createQuery(select);
		return query.getResultList();
	}
}
