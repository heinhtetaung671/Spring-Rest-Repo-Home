package com.jdc.students.domain.account.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.jdc.students.domain.account.constant.EmployeeStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class EmployeeInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EmployeeStatus employeeStatus;
	
	@Column(nullable = false)
	private LocalDate assignAt;
	private LocalDate provationAt;
	private LocalDate resignAt;
	
}
