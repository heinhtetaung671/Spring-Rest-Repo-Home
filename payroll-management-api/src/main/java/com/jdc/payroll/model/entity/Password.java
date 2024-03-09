package com.jdc.payroll.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Password {

	@Id
	private int id;
	private String password;
	private LocalDate createDate;
	private LocalDate modifiedDate;
	
	@OneToOne
	@MapsId
	private Employee employee;
	
}
