package com.jsp.simple_Jpql_laptop_project.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Laptop {

	@Id
	private int laptopId;
	private String laptopName;
	private double laptopPrice;

}
