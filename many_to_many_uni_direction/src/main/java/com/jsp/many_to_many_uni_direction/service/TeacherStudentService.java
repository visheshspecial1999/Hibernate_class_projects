package com.jsp.many_to_many_uni_direction.service;

import java.util.List;

import com.jsp.many_to_many_uni_direction.dao.TeacherStudentDao;
import com.jsp.many_to_many_uni_direction.dto.Teacher;

public class TeacherStudentService {
	TeacherStudentDao dao = new TeacherStudentDao();

	// insertTeacherStudent method
	public void insertTeacherStudent(Teacher teacher) {
		dao.insertTeacherStudent(teacher);
	}

	// searchTeacherStudent method
	public Teacher searchTeacherStudent(int teacherId) {
		return dao.searchTeacherStudent(teacherId);
	}

	// updateTeacherStudent method
	public void updateTeacherStudent(Teacher teacher) {
		Teacher teacher2 = dao.searchTeacherStudent(teacher.getTeacherId());
		if (teacher2 != null) {
			dao.updateTeacherStudent(teacher);
		} else {
			System.out.println("teacherId not found in database");
		}
	}

	// deleteTeacherStudent method
	public void deleteTeacherStudent(int teacherId) {
		Teacher teacher2 = dao.searchTeacherStudent(teacherId);
		if (teacher2 != null) {
			dao.deleteTeacherStudent(teacherId);
		} else {
			System.out.println("teacherId not present or already has been deleted from database");
		}
	}

	// displayTeacherStudent method
	public List<Teacher> displayTeacherStudent() {
		return dao.displayTeacherStudent();
	}
}