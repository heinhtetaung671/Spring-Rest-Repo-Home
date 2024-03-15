package com.jdc.payroll.model.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DepartmentEmployeeContainer extends AbstractEntity{

	@Id
	private int id;
	
	@MapsId("id")
	@OneToOne
	private Department department;
	
	@ColumnDefault("0")
	private int employeeCount;
	
}
