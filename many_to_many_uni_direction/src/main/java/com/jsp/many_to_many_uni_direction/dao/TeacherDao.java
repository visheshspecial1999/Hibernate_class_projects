package com.jsp.many_to_many_uni_direction.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.many_to_many_uni_direction.dto.Student;
import com.jsp.many_to_many_uni_direction.dto.Teacher;

public class TeacherDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// saveTeacher method
	public void saveTeacher(Teacher teacher, int studentId) {
		Student student = entityManager.find(Student.class, studentId);
		List<Student> studentlist = new ArrayList<Student>();
		studentlist.add(student);
		if (student != null) {
//			for (Student student2 : studentlist) {

			teacher.setStudent(studentlist);
			entityTransaction.begin();
			entityManager.persist(teacher);
			entityTransaction.commit();
			System.out.println("data inserted");
		}
//			}

		else {
			System.out.println("id not found");
		}
	}

	// searchTearch method
	public Teacher searchTeacher(int teacherId) {
		Teacher teacher = entityManager.find(Teacher.class, teacherId);
		return teacher;
	}

	// updateTeacher method
	public void updateTeacher(Teacher teacher, int teacherId) {
		Teacher teacher2 = entityManager.find(Teacher.class, teacherId);
		if (teacher2 != null) {
			entityTransaction.begin();
			entityManager.merge(teacher);
			entityTransaction.commit();
			System.out.println("teacher data updated successfully");
		} else {
			System.out.println("teacher id not found in database.so can not update teacher");
		}
	}

	/*
	 * here delete method can not delete the students who are mapped with more than
	 * one teacher.beacuse this project has many to many uni direction flow.so from
	 * student entity class compailer can not select next teacher which is mapped
	 * with student. so this is limitation of delete method for many to many uni
	 * direction.
	 */
	// deleteTeacher method
	public void deleteTeacher(int teacherId) {
		Teacher teacher = entityManager.find(Teacher.class, teacherId);
		entityTransaction.begin();
		entityManager.remove(teacher);
		entityTransaction.commit();
		if (teacher != null) {
			System.out.println("data deleted");
		} else {
			System.out.println("teacherId not found or already has been deleted");
		}
	}

	// displayTeacher method
	public List<Teacher> displayTeacher() {
		String st = "SELECT c FROM Teacher c";
		Query query = entityManager.createQuery(st);
		return query.getResultList();
	}
}