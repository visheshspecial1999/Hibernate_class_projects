package com.jsp.many_to_one_unidirection.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="myteam")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teams implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;
	private String teamName;
	private String teamCaption;
	private int teamSize;
	private String teamCoach;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="competitionId")
	private Competition competition;

}
