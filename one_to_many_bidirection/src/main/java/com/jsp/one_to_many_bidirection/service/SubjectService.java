package com.jsp.one_to_many_bidirection.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.jsp.one_to_many_bidirection.dao.StudentDao;
import com.jsp.one_to_many_bidirection.dao.SubjectDao;
import com.jsp.one_to_many_bidirection.dto.Student;
import com.jsp.one_to_many_bidirection.dto.Subject;

public class SubjectService {

	StudentDao dao2=new StudentDao();
	SubjectDao dao=new SubjectDao();
	
	// saveSubject method
		public void saveSubject(Subject subject) {
			{
			dao.saveSubject(subject);
			}
		}
		
		// searchSubject method
		public Subject searchSubject(int subjectId) {
			return dao.searchSubject(subjectId);	
		}
		
		// updateSubject method
		public void updateSubject(Subject subject,int studentId) {
			Student student=dao2.studentGetById(studentId);
			if(student!=null) {
				subject.setStudent(student);
				dao.updateSubject(subject);
			}
			else {
				System.out.println("studentId not found in database");
			}
		}
		
		// deleteSubject method
		public void deleteSubject(int subjectId) {
			Subject subject=dao.searchSubject(subjectId);
			if(subject!=null) {
				dao.deleteSubject(subject);
			}
			else {
				System.out.println("subjectId not found in database");
			}
		}
		
		// displayAllSubject method 
		public List<Subject> displayAllSubject(){
			return dao.displayAllSubject();
		}
}