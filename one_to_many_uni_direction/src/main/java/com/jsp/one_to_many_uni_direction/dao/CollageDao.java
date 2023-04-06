package com.jsp.one_to_many_uni_direction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.one_to_many_uni_direction.dto.Branch;
import com.jsp.one_to_many_uni_direction.dto.Collage;

public class CollageDao {
	EntityManager entityManager = Persistence.createEntityManagerFactory("vishesh").createEntityManager();

	// insertCollage method
	public void insertCollage(Collage collage) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(collage);
		entityTransaction.commit();
		System.out.println("data saved");
	}

	// searchCollage method
	public Collage searchCollage(int collageId) {
		return entityManager.find(Collage.class, collageId);
	}

	// updateCollage method
	public void updateCollage(Collage collage) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(collage);
		entityTransaction.commit();
		System.out.println("data updated");
	}

	// deleteCollage method
	public void deleteCollage(int collageId) {
		Collage collage = entityManager.find(Collage.class, collageId);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(collage);
		entityTransaction.commit();
		System.out.println("data deleted");
	}

	// displayCollage method
	public List<Collage> displayCollage() {
		String st = "select c from Collage c";
		Query query = entityManager.createQuery(st);
		return query.getResultList();
	}

}