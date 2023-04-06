package com.jsp.one_to_one_uni_direction.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	private int personId;
	private String personName;
	private int personAge;
	@OneToOne
	@JoinColumn(name="passportId")
	private Passport passport;
}
