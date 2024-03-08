package com.jdc.payroll.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
	@PrimaryKeyJoinColumn
	private Employee employee;
	
}
