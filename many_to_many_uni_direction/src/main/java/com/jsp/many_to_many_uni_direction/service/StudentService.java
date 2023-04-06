package com.jsp.many_to_many_uni_direction.service;

import java.util.List;

import com.jsp.many_to_many_uni_direction.dao.StudentDao;
import com.jsp.many_to_many_uni_direction.dto.Student;

public class StudentService {
		
		StudentDao dao=new StudentDao();
	// saveStudent method
		public void saveStudent(Student student) {
			dao.saveStudent(student);
		}
		
		// searchStudent method
		public Student searchStudent(int studentId) {
			Student student= dao.searchStudent(studentId);
			if(student!=null) {
				return student;
			}
			else {
				return null;
			}
		}
	
		// updateStudent method
		public void updateStudent(Student student,int studentId) {
			Student student2=dao.searchStudent(studentId);
			if(student2.getStudentId()==studentId) {
				dao.updateStudent(student);
				System.out.println("data updated");
			}
			else {
				System.out.println("id did not found in database");
			}
		}
		
		// deleteStudent method
		public void deleteStudent(int studentId) {
			dao.deleteStudent(studentId);
		}
		
		// displayStudent method
		public List<Student> displayStudent() {
			return dao.displayStudent();
		}
}