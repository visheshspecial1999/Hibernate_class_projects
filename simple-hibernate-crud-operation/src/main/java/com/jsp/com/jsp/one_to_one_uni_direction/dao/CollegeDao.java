package com.jsp.com.jsp.one_to_one_uni_direction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.com.jsp.one_to_one_uni_direction.dto.College;

public class CollegeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishesh");

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EntityTransaction entityTransaction = entityManager.getTransaction();

	// saveCollage method
	public void saveCollege(College college) {

		entityTransaction.begin();
		entityManager.persist(college);
		entityTransaction.commit();
		System.out.println("data saved");

	}

	// getByCollageId method
	public College getByCollegeId(int collegeId) {

		College college = entityManager.find(College.class, collegeId);

		return college;
	}

	// updateCollage method
	public void updateCollegeById(int collegeId, String collegeName, String collegeAddress) {

		College college = getByCollegeId(collegeId);
		college.setCollegeName(collegeName);
		college.setCollegeAddress(collegeAddress);

		entityTransaction.begin();
		entityManager.merge(college);
		entityTransaction.commit();
		System.out.println("data updated");
	}

	// deleteCollage method
	public void deleteCollegeById(int collegeId) {

		College college = entityManager.find(College.class, collegeId);
		entityTransaction.begin();
		entityManager.remove(college);
		entityTransaction.commit();
		System.out.println("data deleted");
	}

	// displayCollage method
	public List<College> displayCollege() {
		String st = "select c from College c";
		Query query = entityManager.createQuery(st);
		return query.getResultList();
	}
}
