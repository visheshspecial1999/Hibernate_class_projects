package com.jsp.one_to_many_bidirection.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subject {
	
	@Id
	private int subjectId;
	private String subjectName;
	private String subjectAuthor;
	private double subjectPrice;
	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;
	public Subject(int subjectId, String subjectName, String subjectAuthor, double subjectPrice) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectAuthor = subjectAuthor;
		this.subjectPrice = subjectPrice;
	}
	
	
	

}
