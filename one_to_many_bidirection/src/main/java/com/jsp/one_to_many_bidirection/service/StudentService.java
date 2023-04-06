package com.jsp.one_to_many_bidirection.service;

import java.util.List;

import com.jsp.one_to_many_bidirection.dao.StudentDao;
import com.jsp.one_to_many_bidirection.dto.Student;
import com.jsp.one_to_many_bidirection.dto.Subject;

public class StudentService {

	StudentDao dao = new StudentDao();

	// saveStudent method
	public void saveStudent(Student student) {
		dao.saveStudent(student);
	}

	// searchStudent method
	public Student searchStudent(int studentId) {
		return dao.studentGetById(studentId);
	}

	// updateStudent method
	public void updateStudent(Student student) {
		Student student2 = dao.studentGetById(student.getStudentId());
		if (student2 != null) {
			dao.updateStudent(student);
		} else {
			System.out.println("studentId not found in database");
		}
	}

	// deleteStudent method
	public void deleteStudent(int studentId) {
		dao.deleteStudent(studentId);
	}

	// displayAllStudent method
	public List<Student> displayAllStudent() {
		return dao.displayAllStudent();
	}
}
