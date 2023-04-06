package com.jsp.many_to_many_uni_direction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.many_to_many_uni_direction.dto.Student;

public class StudentDao {
	
	EntityManager entityManager=Persistence.createEntityManagerFactory("vishesh").createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
		// saveStudent method
	public void saveStudent(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		System.out.println("data inserted");	
	}
	
	// searchStudent method
	public Student searchStudent(int studentId) {
		Student student=entityManager.find(Student.class, studentId);
		return student;
	}
	
	// updateStudent method
	public void updateStudent(Student student) {
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
	}
	
	// deleteStudent method
	public void deleteStudent(int studentId) {
		Student st=entityManager.find(Student.class, studentId);
		if(st!=null) {
			entityTransaction.begin();
		entityManager.remove(st);
		entityTransaction.commit();
		System.out.println("data deleted");
		}
		else {
			System.out.println("id not found in database or already has been deleted");
		}
		
	}
	
	// displayStudent method
	public List<Student> displayStudent() {
		String st="SELECT c FROM Student c";
		Query query=entityManager.createQuery(st);
		return query.getResultList();
				
	}
}