package com.jdc.home.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.home.model.input.CourseForm;
import com.jdc.home.model.output.DataModificationResult;
import com.jdc.home.model.repo.CategoryRepo;
import com.jdc.home.model.repo.CourseRepo;

@Service
@Transactional(readOnly = true)
public class CourseService {
	
	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private CourseCodeGeneratingService courseCodeGeneratingService;
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Transactional
	public DataModificationResult<String> save(CourseForm form) {
		var category = categoryRepo.findById(form.categoryId()).orElseThrow();
		
		String courseCode = courseCodeGeneratingService.nextAndGetCourseCode(category);
		
		var course = form.entityWithCode(courseCode);
		course.setCategory(category);
		courseRepo.save(course);
		return DataModificationResult.createResult(courseCode, "Course", "Code");
	}
	
}
