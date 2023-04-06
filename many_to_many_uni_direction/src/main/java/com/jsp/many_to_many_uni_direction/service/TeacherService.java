package com.jsp.many_to_many_uni_direction.service;

import java.util.List;

import com.jsp.many_to_many_uni_direction.dao.TeacherDao;
import com.jsp.many_to_many_uni_direction.dto.Teacher;

public class TeacherService {

	TeacherDao dao = new TeacherDao();

	// saveTeacher method
	public void saveTeacher(Teacher teacher, int studentId) {
		dao.saveTeacher(teacher, studentId);
	}

	// searchTeacher method
	public Teacher searchTeacher(int teacherId) {
		return dao.searchTeacher(teacherId);
	}

	// updateTeacher method
	public void updateTeacher(Teacher teacher, int teacherId) {
		dao.updateTeacher(teacher, teacherId);
	}

	// deleteTeacher method
	public void deleteTeacher(int teacherId) {
		dao.deleteTeacher(teacherId);
	}

	// displayTeacher method
	public List<Teacher> displayTeacher() {

		List<Teacher> list = dao.displayTeacher();
		return list;
	}
}