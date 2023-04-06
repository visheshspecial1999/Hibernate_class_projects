package com.jsp.one_to_many_bidirection.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.jsp.one_to_many_bidirection.dto.Student;
import com.jsp.one_to_many_bidirection.dto.Subject;
import com.jsp.one_to_many_bidirection.service.SubjectService;

public class SubjectController {
	public static void main(String[] args) {
		while (true) {

			Scanner s = new Scanner(System.in);
			SubjectService service=new SubjectService(); 
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Subject subject=new Subject();
				subject.setSubjectId(9);
				subject.setSubjectName("electronics");
				subject.setSubjectPrice(225);
				subject.setSubjectAuthor("KR sonas");
				
				Student student=new Student();
				student.setStudentId(105);
				student.setStudentName("aman rastohi");
				student.setStudentEmail("rastogi@gmail.com");
				subject.setStudent(student);
				service.saveSubject(subject);
				
			}
				break;

			case 2: {
					System.out.println("enter subjectId: ");
					int subjectId=s.nextInt();
					Subject subject=service.searchSubject(subjectId);
					if(subject!=null) {
					System.out.println("---------------subject.details--------------");
					System.out.println("subjectId: "+subject.getSubjectId());
					System.out.println("subjectName: "+subject.getSubjectName());
					System.out.println("subjectPrice: "+subject.getSubjectPrice());
					System.out.println("subjectAuthor: "+subject.getSubjectAuthor());
					System.out.println("................student.details...............");
					System.out.println("studentId: "+subject.getStudent().getStudentId());
					System.out.println("studentName: "+subject.getStudent().getStudentName());
					System.out.println("studentEmail: "+subject.getStudent().getStudentEmail());
					System.out.println();
					}
					else {
						System.out.println("subjectId not present in database");
					}
			}
				break;

			case 3: {
				Subject subject=new Subject();
				subject.setSubjectId(10);
				subject.setSubjectName("Gologoy");
				subject.setSubjectPrice(950);
				subject.setSubjectAuthor("ramesh gupta");
				System.out.println("enter studentId: ");
				int studentId=s.nextInt();
				service.updateSubject(subject,studentId);
			}
				break;

			case 4: {System.out.println("enter subjectId: ");
			int subjectId=s.nextInt();
			service.deleteSubject(subjectId);

			}
				break;

			case 5: {
				List<Subject> list=service.displayAllSubject();
				for (Subject subject : list) {
				if(subject!=null) {
					System.out.println("---------------subject.details--------------");
					System.out.println("subjectId: "+subject.getSubjectId());
					System.out.println("subjectName: "+subject.getSubjectName());
					System.out.println("subjectPrice: "+subject.getSubjectPrice());
					System.out.println("subjectAuthor: "+subject.getSubjectAuthor());
					System.out.println("................student.details...............");
					System.out.println("studentId: "+subject.getStudent().getStudentId());
					System.out.println("studentName: "+subject.getStudent().getStudentName());
					System.out.println("studentEmail: "+subject.getStudent().getStudentEmail());
					System.out.println();
					}
					else {
						System.out.println("subjectId not present in database");
					}
				
				}
			}
				break;

			case 6: {
					System.out.println("System closed");
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