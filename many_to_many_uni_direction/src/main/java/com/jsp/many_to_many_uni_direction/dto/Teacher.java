package com.jsp.many_to_many_uni_direction.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
	
	@Id
	private int teacherId;
	private String teacherName;
	private String teacherEmail;
	private int  yearOfExperince;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	private List<Student> student;

}
