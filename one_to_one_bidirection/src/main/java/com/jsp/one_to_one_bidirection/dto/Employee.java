package com.jsp.one_to_one_bidirection.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
	
	@Id
	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="laptop")
	private Laptop laptop;

	public Employee(int employeeId, String employeeName, String employeeEmail) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
	}
	
	
	
	
}
