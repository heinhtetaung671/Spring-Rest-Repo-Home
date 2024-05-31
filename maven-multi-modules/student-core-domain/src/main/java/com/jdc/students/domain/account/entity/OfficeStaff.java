package com.jdc.students.domain.account.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class OfficeStaff extends LoginUser{

	@Embedded
	private EmployeeInfo employeeInfo;
	
}
