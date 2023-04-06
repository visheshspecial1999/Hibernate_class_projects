package com.jsp.one_to_many_bidirection.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.jsp.one_to_many_bidirection.dto.Student;
import com.jsp.one_to_many_bidirection.dto.Subject;
import com.jsp.one_to_many_bidirection.service.StudentService;

public class StudentController {

	public static void main(String[] args) {

		while (true) {
			EntityManager entityManager = Persistence.createEntityManagerFactory("vishesh").createEntityManager();
			Scanner s = new Scanner(System.in);
			StudentService service = new StudentService();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Student student = new Student();
				student.setStudentId(104);
				student.setStudentName("anshika");
				student.setStudentEmail("anshika@gmail.com");

				List<Subject> list = new ArrayList<Subject>();
				Subject subject = new Subject();
				subject.setSubjectId(7);
				subject.setSubjectName("physic");
				subject.setSubjectAuthor("kumar mittal");
				subject.setSubjectPrice(550);
				subject.setStudent(student);

				Subject subject1 = new Subject();
				subject1.setSubjectId(8);
				subject1.setSubjectName("chemestry");
				subject1.setSubjectAuthor("k n shrma");
				subject1.setSubjectPrice(600);
				subject1.setStudent(student);

				list.add(subject);
				list.add(subject1);
				student.setSubject(list);
				service.saveStudent(student);

			}
				break;

			case 2: {
				System.out.println("enter studentId: ");
				int studentId = s.nextInt();
				Student student = service.searchStudent(studentId);
				if (student != null) {
					System.out.println("------------------student.person.details-------------------------");
					System.out.println("studentId: " + student.getStudentId());
					System.out.println("studentName: " + student.getStudentName());
					System.out.println("studentEmail: " + student.getStudentEmail());
					System.out.println("...................student.subject.details-------------------------");
					List<Subject> subjects = student.getSubject();
					for (Subject subject : subjects) {
						System.out.println("subjectId: " + subject.getSubjectId());
						System.out.println("subjectName: " + subject.getSubjectName());
						System.out.println("subjectPrice: " + subject.getSubjectPrice());
						System.out.println("subjectAuthor: " + subject.getSubjectAuthor());
						System.out.println();
					}
					System.out.println();
				} else {
					System.out.println("studentId not present in database");
				}
			}
				break;

			case 3: {
				Student student = new Student(103, "jitendra", "jitendra@gmail.com");
				Subject subject = new Subject(5, "socielscience", "bp bharadwaj", 750);
				subject.setStudent(student);
				Subject subject2 = new Subject(6, "geography", "vikram shrma", 1000);
				subject2.setStudent(student);
				List<Subject> list = new ArrayList<Subject>();
				list.add(subject);
				list.add(subject2);
				student.setSubject(list);
				service.updateStudent(student);
			}
				break;

			case 4: {
				System.out.println("enter studentId: ");
				int studentId = s.nextInt();
				service.deleteStudent(studentId);
			}
				break;

			case 5: {
				List<Student> list = service.displayAllStudent();
				if (list != null) {
					for (Student student : list) {
						System.out.println("------------------student.person.details-------------------------");
						System.out.println("studentId: " + student.getStudentId());
						System.out.println("studentName: " + student.getStudentName());
						System.out.println("studentEmail: " + student.getStudentEmail());
						System.out.println("...................student.subject.details-------------------------");
						List<Subject> subjects = student.getSubject();
						for (Subject subject : subjects) {
							System.out.println("subjectId: " + subject.getSubjectId());
							System.out.println("subjectName: " + subject.getSubjectName());
							System.out.println("subjectPrice: " + subject.getSubjectPrice());
							System.out.println("subjectAuthor: " + subject.getSubjectAuthor());
							System.out.println();
						}
	
					}
					System.out.println();
				} else {
					System.out.println("table is empty in database");
				}

			}
				break;

			case 6: {
				System.out.println("System closed");
				System.exit(choice);
			}
				break;

			default: {
				System.out.println("invalid choice");
			}
			}
		}
	}

}
