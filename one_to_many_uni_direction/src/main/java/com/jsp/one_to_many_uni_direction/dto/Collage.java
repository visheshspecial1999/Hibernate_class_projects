package com.jsp.one_to_many_uni_direction.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collage {
	
	@Id
	private int collageId;
	private String collageName;
	private String collageAddress;
	private String collageType;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branchs;
	public Collage(int collageId, String collageName, String collageAddress, String collageType) {
		super();
		this.collageId = collageId;
		this.collageName = collageName;
		this.collageAddress = collageAddress;
		this.collageType = collageType;
	}
	
	
	

}
