package com.jdc.payroll.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	private Employee headOfDepartment;
	
	private String phone;
	private String email;
	private String desc;
	
	@OneToMany(mappedBy = "department")
	private List<Position> positions;
	
}
