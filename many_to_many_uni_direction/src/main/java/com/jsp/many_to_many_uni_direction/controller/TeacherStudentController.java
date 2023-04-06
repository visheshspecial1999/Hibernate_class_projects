package com.jsp.many_to_many_uni_direction.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.many_to_many_uni_direction.dto.Student;
import com.jsp.many_to_many_uni_direction.dto.Teacher;
import com.jsp.many_to_many_uni_direction.service.TeacherService;
import com.jsp.many_to_many_uni_direction.service.TeacherStudentService;

public class TeacherStudentController {

	public static void main(String[] args) {
		while (true) {
			Scanner s = new Scanner(System.in);
			TeacherStudentService service = new TeacherStudentService();
			System.out.println();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Teacher teacher = new Teacher();
				System.out.println("enter teacherId: ");
				teacher.setTeacherId(s.nextInt());
				System.out.println("enter teacherName: ");
				String teacherName = s.next();
				teacherName += s.nextLine();
				teacher.setTeacherName(teacherName); 
				System.out.println("enter teacherEmail: ");
				teacher.setTeacherEmail(s.nextLine());
				System.out.println("enter yearOfExperince");
				teacher.setYearOfExperince(s.nextInt());

				Student student = new Student();
				System.out.println("enter studentId: ");
				student.setStudentId(s.nextInt());
				System.out.println("enter studentName: ");
				String studentName = s.next();
				studentName += s.nextLine();
				student.setStudentName(studentName);
				System.out.println("enter studentEmail: ");
				student.setStudentEmail(s.nextLine());
				System.out.println("enter studentBranch: ");
				student.setStudentBranch(s.nextLine());
				Student student1 = new Student(106, "bcd", "bcd@gmail", "ec");
				List<Student> list = new ArrayList<Student>();
				list.add(student);
				list.add(student1);
				teacher.setStudent(list);
				service.insertTeacherStudent(teacher);

			}
				break;
			case 2: {
				System.out.println("enter teacherId: ");
				int teacherId = s.nextInt();
				Teacher teacher = service.searchTeacherStudent(teacherId);
				if (teacher != null) {
					System.out.println(".........................teacherdetails.................................");
					System.out.println("teacherId: " + teacher.getTeacherId());
					System.out.println("teacherName: " + teacher.getTeacherName());
					System.out.println("teacherEmail: " + teacher.getTeacherEmail());
					System.out.println("yearOfExperince: " + teacher.getYearOfExperince());
					System.out.println();
					List<Student> list = teacher.getStudent();
					System.out.println("...................................student details.........................");
					for (Student student : list) {
						System.out.println("studentId: " + student.getStudentId());
						System.out.println("studentName: " + student.getStudentName());
						System.out.println("studentEmail: " + student.getStudentEmail());
						System.out.println("studentBranch: " + student.getStudentBranch());
					}
				} else {
					System.out.println("teacherId not presernt in database");
				}
			}
				break;
			case 3: {
				Teacher teacher = new Teacher();
				System.out.println("enter teacherId: ");
				teacher.setTeacherId(s.nextInt());
				System.out.println("enter teacherName: ");
				String teacherName = s.next();
				teacherName += s.nextLine();
				teacher.setTeacherName(teacherName);
				System.out.println("enter teacherEmail: ");
				teacher.setTeacherEmail(s.nextLine());
				System.out.println("enter yearOfExperince");
				teacher.setYearOfExperince(s.nextInt());

				Student student = new Student();
				System.out.println("enter studentId: ");
				student.setStudentId(s.nextInt());
				System.out.println("enter studentName: ");
				String studentName = s.next();
				studentName += s.nextLine();
				student.setStudentName(studentName);
				System.out.println("enter studentEmail: ");
				student.setStudentEmail(s.nextLine());
				System.out.println("enter studentBranch: ");
				student.setStudentBranch(s.nextLine());
				List<Student> list = new ArrayList<Student>();
				list.add(student);
				teacher.setStudent(list);
				service.updateTeacherStudent(teacher);
			}
				break;
			case 4: {
				System.out.println("enter teacherId: ");
				int teacherId = s.nextInt();
				service.deleteTeacherStudent(teacherId);

			}
				break;
			case 5: {
				List<Teacher> list = service.displayTeacherStudent();
				
				for (Teacher teacher : list) {
					System.out.println("..................teacher_details.......................");
					System.out.println("teacherId: " + teacher.getTeacherId());
					System.out.println("teacherName: " + teacher.getTeacherName());
					System.out.println("teacherEmail: " + teacher.getTeacherEmail());
					System.out.println("teacherYearOfExperince: " + teacher.getYearOfExperince());
					System.out.println();
					List<Student> students = teacher.getStudent();
					System.out.println("....................student-details......................");
					for (Student student : students) {
						System.out.println("studentId: " + student.getStudentId());
						System.out.println("studentName: " + student.getStudentName());
						System.out.println("studentEmail: " + student.getStudentEmail());
						System.out.println("studentBranch: " + student.getStudentBranch());
						System.out.println();
					}
				}
			}
				break;

			case 6: {
				System.out.println("System closed");
				System.exit(choice);
			}
			default: {
				System.out.println("invalid choice!!!");
			}
			}
		}
	}
}