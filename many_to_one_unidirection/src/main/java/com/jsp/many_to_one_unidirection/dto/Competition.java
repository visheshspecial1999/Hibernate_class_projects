package com.jsp.many_to_one_unidirection.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "indiancompetition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int competitionId;
	@Column(nullable = false)
	private String competitionName;
	private int competitionYear;
	private String sponsorsName;
	@Transient
	private String competitionChairman;
}