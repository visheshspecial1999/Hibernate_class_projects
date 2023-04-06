package com.jsp.many_to_many_bidirection.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	
	@Id
	private int customerId;
	private String customerName;
	private long customerAccountNumber;
	private long customerAddharNumber;
	private long customerPhoneNumber;
	
	@ManyToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Bank> bank;

	public Customer(int customerId, String customerName, long customerAccountNumber, long customerAddharNumber,
			long customerPhoneNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAccountNumber = customerAccountNumber;
		this.customerAddharNumber = customerAddharNumber;
		this.customerPhoneNumber = customerPhoneNumber;
	}

	
}
