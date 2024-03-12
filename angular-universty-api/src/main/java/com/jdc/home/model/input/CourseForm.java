package com.jdc.home.model.input;

import com.jdc.home.model.entity.Course;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseForm(
		@NotBlank(message = "Please Enter Course Name.")
		String name, 
		@NotNull(message = "Please Select Category.")
		Integer categoryId, 
		@Min(value = 10000, message = "Please Enter Fees Atleast 10000ks")
		int fees,
		@Min(value = 1, message = "Please Enter Duration Atleast 1 month.")
		short duration, 
		String description) {

	// no category include. you have to set yourself.
	public Course entity() {
		
		var course = new Course();
		course.setName(name);
		course.setFees(fees);
		course.setDuration(duration);
		course.setDescription(description);
		return course;
	}
	
	public Course entityWithCode(String code) {
		var c = entity();
		c.setId(code);
		return c;
	}
	
}
