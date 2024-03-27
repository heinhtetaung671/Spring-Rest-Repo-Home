package com.jdc.payroll.api.input;

import com.jdc.payroll.model.entity.Department;

import jakarta.validation.constraints.NotBlank;

public record DepartmentCreateForm(
		@NotBlank(message = "Please enter department code.")
		String code,
		@NotBlank(message = "Please enter department name.")
		String name,
		@NotBlank(message = "Please enter department phone.")
		String phone,
		@NotBlank(message = "Please enter department email.")
		String email,
		String desc
		) {
	
	public Department entity() {
		var entity = new Department();
		entity.setCode(code);
		entity.setName(name);
		entity.setPhone(phone);
		entity.setEmail(email);
		entity.setDesc(desc);
		return entity;
	}

}
