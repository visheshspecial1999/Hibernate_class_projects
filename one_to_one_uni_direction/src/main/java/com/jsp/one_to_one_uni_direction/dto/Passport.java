package com.jsp.one_to_one_uni_direction.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Entity
@Data
public class Passport {
	@Id
	private  int passportId;
	private String passportColor;
	private String passportType;
	@UpdateTimestamp
	private LocalDateTime dateTime;
//	@CreationTimestamp
//	private LocalDateTime updatedDate;
	
}
