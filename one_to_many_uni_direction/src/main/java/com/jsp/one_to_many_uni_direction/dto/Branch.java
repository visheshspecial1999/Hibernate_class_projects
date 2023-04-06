package com.jsp.one_to_many_uni_direction.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
	
	@Id
	private int branchId;
	private String branchName;
	private String branchBuilding;
	

}
