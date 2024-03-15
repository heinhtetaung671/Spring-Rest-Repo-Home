package com.jdc.payroll.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Position extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name; 
	
	@ManyToOne(optional = false)
	private Department department;	
	
}
