package com.jsp.one_to_many_bidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.one_to_many_bidirection.dto.Subject;

public class SubjectDao {
	EntityManager entityManager=Persistence.createEntityManagerFactory("vishesh").createEntityManager();
	
	// saveSubject method
	public void saveSubject(Subject subject) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(subject);
		entityTransaction.commit();
		System.out.println("data inserted");
	}
	
	// searchSubject method
	public Subject searchSubject(int subjectId) {
		return entityManager.find(Subject.class, subjectId);
	}
	
	// updateSubject method
	public void updateSubject(Subject subject) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(subject);
		entityTransaction.commit();
		System.out.println("data updated");
	}
	
	// deleteSubject method
	public void deleteSubject(Subject subject) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(subject);
		entityTransaction.commit();
		System.out.println("data deleted");
	}
	
	// displayAllSubject method 
	public List<Subject> displayAllSubject(){
		String st="SELECT c FROM Subject c";
		Query query=entityManager.createQuery(st);
		return query.getResultList();
	}
}
