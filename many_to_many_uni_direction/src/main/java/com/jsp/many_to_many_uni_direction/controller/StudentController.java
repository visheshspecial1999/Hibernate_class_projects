package com.jsp.many_to_many_uni_direction.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.many_to_many_uni_direction.dto.Student;
import com.jsp.many_to_many_uni_direction.dto.Teacher;
import com.jsp.many_to_many_uni_direction.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		while (true) {

			Scanner s = new Scanner(System.in);
			System.out.println();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete");
//		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vishesh");
			StudentService service = new StudentService();
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				
				Student student = new Student();
				System.out.print("enter studentId: ");
				student.setStudentId(s.nextInt());
				System.out.println("enter studentName: ");
				String studentName = s.next();
				studentName += s.nextLine();
				student.setStudentName(studentName);
				System.out.println("enter studentEmail: ");
				String studentEmail = s.nextLine();
				student.setStudentEmail(studentEmail);
				System.out.println("enter studentBranch: ");
				student.setStudentBranch(s.nextLine());
//		Student student2=new Student(103,"jitendra","jitendra@gmail.com","EC");
				service.saveStudent(student);
//		service.saveStudent(student2);
			}
				break;

			case 2: {
				
				// searchStudent method
				System.out.println("enter studentId: ");
				Student student=service.searchStudent(s.nextInt());
				if(student!=null) {
				System.out.println("--------------------------------------student details---------------------------------------------");
				System.out.println("studentId: "+student.getStudentId());
				System.out.println("studentName: "+student.getStudentName());
				System.out.println("studentEmail: "+student.getStudentEmail());
				System.out.println("studentBranch: "+student.getStudentBranch());
				}
				else {
					System.out.println("please check studentId you have passed");
				}
			}
				break;

			case 3: {
				Student student = new Student();
				System.out.print("enter studentId: ");
				int studentId=s.nextInt();
				student.setStudentId(studentId);
				System.out.println("enter studentName: ");
				String studentName = s.next();
				studentName += s.nextLine();
				student.setStudentName(studentName);
				System.out.println("enter studentEmail: ");
				String studentEmail = s.nextLine();
				student.setStudentEmail(studentEmail);
				System.out.println("enter studentBranch: ");
				student.setStudentBranch(s.nextLine());
				service.updateStudent(student,studentId);
			}
				break;

			case 4: {
//				System.out.println("enter studentId: ");
//				int studentId=s.nextInt();
//				service.deleteStudent(studentId);
				System.out.println("you can not perform this action due to uni direction and student is under control of teacher entity class");
			}
				break;

			case 5: {
					List<Student>list=service.displayStudent();
					System.out.println("....................................student-details.....................................");
					for (Student student : list) {
						System.out.println("studentId: "+student.getStudentId());
						System.out.println("studentName: "+student.getStudentName());
						System.out.println("studentEmail: "+student.getStudentEmail());
						System.out.println("studentBranch: "+student.getStudentBranch());
						System.out.println();
					}
			}
				break;

			default: {
				System.out.println("invalid choice!!!");
			}
			}

		}
	}
}