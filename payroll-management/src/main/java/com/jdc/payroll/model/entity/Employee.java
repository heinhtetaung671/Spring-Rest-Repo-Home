package com.jdc.payroll.model.entity;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
public class Employee {
	
	public static final String EMPLOYEE_CODE_FORMAT = "%s%3d";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	
	@OneToOne(mappedBy = "employee")
	private Password password;
	
	@ElementCollection
	@JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = "phone"))
	private List<String> phone;
	@ElementCollection
	@JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
	private List<String> email;
	
	@ManyToOne
	private Position position;
	
	public void setPositionAndCode(Position position) {
		this.position = position;
		setCode();
	}
	
	public void updateCode() {
		setCode();
	}
	
	public void setCode() {
		this.code = this.position != null && id != 0 ? EMPLOYEE_CODE_FORMAT.formatted(Optional.ofNullable(this.position.getDepartment()).orElseThrow().getCode(), id) : null;
	}
	
}
