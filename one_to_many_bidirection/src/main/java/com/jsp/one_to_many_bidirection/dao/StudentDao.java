package com.jsp.one_to_many_bidirection.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.one_to_many_bidirection.dto.Student;
import com.jsp.one_to_many_bidirection.dto.Subject;

public class StudentDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("vishesh").createEntityManager();

	// saveStudent method
	public void saveStudent(Student student) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		System.out.println("data inserted");
	}

	// studentGetById method
	public Student studentGetById(int studentId) {
		Student student = entityManager.find(Student.class, studentId);
		return student;
	}

	// updateStudent method
	public void updateStudent(Student student) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		System.out.println("data inserted");
	}

	// deleteStudent method
	public void deleteStudent(int studentId) {
		Student student = entityManager.find(Student.class, studentId);
		if (student != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			System.out.println("data deleted");
		} else {
			System.out.println("studentId not found or already has been deleted");
		}
	}

	// displayAllStudent method
	public List<Student> displayAllStudent() {
		String st = "SELECT c FROM Student c";
		Query query = entityManager.createQuery(st);
		return query.getResultList();
	}
}