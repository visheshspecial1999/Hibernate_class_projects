package com.jsp.many_to_many_uni_direction.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.many_to_many_uni_direction.dto.Student;
import com.jsp.many_to_many_uni_direction.dto.Teacher;
import com.jsp.many_to_many_uni_direction.service.TeacherService;

public class TeacherController {

	public static void main(String[] args) {
		while (true) {
			Scanner s = new Scanner(System.in);
			System.out.println();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			TeacherService service = new TeacherService();
			switch (choice) {
			case 1: {

				Teacher teacher = new Teacher();
				System.out.println("enter teacherId: ");
				teacher.setTeacherId(s.nextInt());
				System.out.println("enter teacherName: ");
				String teacherName=s.next();
				teacherName+=s.nextLine();
				teacher.setTeacherName(teacherName);
				System.out.println("enter teacherEmail: ");
				teacher.setTeacherEmail(s.nextLine());
				System.out.println("enter yearOfExperince");
				teacher.setYearOfExperince(s.nextInt());
				System.out.println("enter studentId");
				int studentId=s.nextInt();
				service.saveTeacher(teacher, studentId);
			}
				break;

			case 2: {
				System.out.println("enter teacherId: ");
				int teacherId = s.nextInt();
				Teacher teacher = service.searchTeacher(teacherId);
				if (teacher != null) {
					System.out.println(".........................teacher details.................................");
					System.out.println("teacherId: " + teacher.getTeacherId());
					System.out.println("teacherName: " + teacher.getTeacherName());
					System.out.println("teacherEmail: " + teacher.getTeacherEmail());
					System.out.println("yearOfExperince: " + teacher.getYearOfExperince());
				} else {
					System.out.println("teacherId is not found in database");
				}
			}
				break;

			case 3: {
				Teacher teacher = new Teacher();
				System.out.println("enter teacherId: ");
				int teacherId=s.nextInt();
				teacher.setTeacherId(teacherId);
				System.out.println("enter teacherName: ");
				String teacherName=s.next();
				teacherName+=s.nextLine();
				teacher.setTeacherName(teacherName);
				System.out.println("enter teacherEmail: ");
				teacher.setTeacherEmail(s.nextLine());
				System.out.println("enter yearOfExperince");
				teacher.setYearOfExperince(s.nextInt());
				service.updateTeacher(teacher,teacherId);
			
			}
				break;

			case 4: {
				System.out.println("enter teacherId: ");
				int teacherId = s.nextInt();
				service.deleteTeacher(teacherId);
			}
				break;

			case 5: {
				System.out.println("----------------------------teacher details-----------------------------");
				List<Teacher> list=service.displayTeacher();
				for (Teacher teacher : list) {
					System.out.println("teacherId: "+teacher.getTeacherId());
					System.out.println("teacherName: "+teacher.getTeacherName());
					System.out.println("teacherEmail: "+teacher.getTeacherEmail());
					System.out.println("yearOfExperince: "+teacher.getYearOfExperince());
					System.out.println();
					
				}
			}
				break;

			case 6: {
				System.out.println("system closed");
				System.exit(choice);
			}
				break;

			default: {
				System.out.println("invalid choice!!!");
			}
			}
		}
	}
}