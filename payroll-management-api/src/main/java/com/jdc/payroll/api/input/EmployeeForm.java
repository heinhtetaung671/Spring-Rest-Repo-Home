package com.jdc.payroll.api.input;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeForm(
		@NotBlank(message = "Please enter employee name.")
		String name,
		@NotBlank(message = "Please enter employee password.")
		String password,
		@Min(value = 1, message = "Please select department.")
		int departmentId,
		@Min(value = 1, message = "Please select position.")
		int positionId,
		@NotNull(message = "Please enter at least one phone number.")
		List<String> phones,
		@NotNull(message = "Please enter at least one email.")
		List<String> emails) {

}
