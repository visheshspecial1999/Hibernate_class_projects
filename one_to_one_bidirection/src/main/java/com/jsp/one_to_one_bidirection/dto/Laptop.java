package com.jsp.one_to_one_bidirection.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Laptop {
	
	@Id
	private int laptopId;
	private String laptopColor;
	private double laptopPrice;
	@OneToOne(mappedBy="laptop",cascade = CascadeType.ALL)
	private Employee employee;
	public Laptop(int laptopId, String laptopColor, double laptopPrice) {
		super();
		this.laptopId = laptopId;
		this.laptopColor = laptopColor;
		this.laptopPrice = laptopPrice;
	}
	
	
	
	
 
}
