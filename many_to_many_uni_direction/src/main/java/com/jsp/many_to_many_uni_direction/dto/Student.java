package com.jsp.many_to_many_uni_direction.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	
	@Id
	private int studentId;
	private String studentName;
	private String studentEmail;
	private String studentBranch;	
}
