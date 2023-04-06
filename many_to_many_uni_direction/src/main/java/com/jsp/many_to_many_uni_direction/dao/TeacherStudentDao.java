package com.jsp.many_to_many_uni_direction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.many_to_many_uni_direction.dto.Teacher;

public class TeacherStudentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// insertTeacherStudent method
	public void insertTeacherStudent(Teacher teacher) {
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
		System.out.println("data inserted");
	}

	// searchTeacherStudent method
	public Teacher searchTeacherStudent(int teacherId) {
		Teacher teacher = entityManager.find(Teacher.class, teacherId);
		return teacher;
	}

	// updateTeacherStudent method
	public void updateTeacherStudent(Teacher teacher) {
		entityTransaction.begin();
		entityManager.merge(teacher);
		entityTransaction.commit();
		System.out.println("data updated");
	}

	/*
	 * here delete method can not delete the students who are mapped with more than
	 * one teacher.beacuse this project has many to many uni direction flow.so from
	 * student entity class compailer can not select next teacher which is mapped
	 * with student. so this is limitation of delete method for many to many uni
	 * direction.
	 */
	// deleteTeacherStudent method
	public void deleteTeacherStudent(int teacherId) {
		Teacher teacher = entityManager.find(Teacher.class, teacherId);
		entityTransaction.begin();
		entityManager.remove(teacher);
		entityTransaction.commit();
		System.out.println("data deleted");
	}

	// displayTeacherStudent method
	public List<Teacher> displayTeacherStudent() {
		String st = "select c from Teacher c";
		Query query = entityManager.createQuery(st);
		return query.getResultList();
	}
}
