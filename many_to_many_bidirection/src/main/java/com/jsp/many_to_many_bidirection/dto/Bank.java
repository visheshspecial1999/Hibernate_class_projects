package com.jsp.many_to_many_bidirection.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bank {
	
	@Id
	private int bankId;
	private String bankName;
	private String bankAddress;
	private String bankIfscCode;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="bankcustomer",
	joinColumns=@JoinColumn(name="bankId"),
	inverseJoinColumns = @JoinColumn(name="customerId"))
	private List<Customer> customer;

	public Bank(int bankId, String bankName, String bankAddress, String bankIfscCode) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.bankIfscCode = bankIfscCode;
	}
	
	
}
