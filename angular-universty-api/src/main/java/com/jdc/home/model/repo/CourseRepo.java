package com.jdc.home.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.home.model.entity.Course;

public interface CourseRepo extends JpaRepository<Course, String>{

	
	
}
