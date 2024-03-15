package com.jdc.payroll.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Password extends AbstractEntity{

	@Id
	private int id;
	@Column(nullable = false)
	private String password;
	
	@OneToOne(mappedBy = "password")
	@MapsId
	private Employee employee;
	
}
