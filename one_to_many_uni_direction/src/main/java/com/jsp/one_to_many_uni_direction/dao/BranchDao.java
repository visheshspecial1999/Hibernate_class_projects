package com.jsp.one_to_many_uni_direction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.one_to_many_uni_direction.dto.Branch;

public class BranchDao {
	EntityManager entityManager = Persistence.createEntityManagerFactory("vishesh").createEntityManager();

	// insertBranch method
	public void insertBranch(Branch branch) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		System.out.println("data saved");
	}

	// searchBranch method
	public Branch searchBranch(int branchId) {
		return entityManager.find(Branch.class, branchId);
	}

	// updateBranch method
	public void updateBarnch(Branch branch) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();
		System.out.println("data updated");
	}

	// deleteBranch method
	public void deleteBranch(int branchId) {
		Branch branch = entityManager.find(Branch.class, branchId);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(branch);
		entityTransaction.commit();
		System.out.println("data deleted");
	}

	// displayBranch method
	public List<Branch> displayBranch() {
		String st = "select c from Branch c";

		Query query = entityManager.createQuery(st);

		return query.getResultList();
	}
}