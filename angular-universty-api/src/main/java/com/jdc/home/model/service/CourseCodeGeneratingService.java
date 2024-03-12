package com.jdc.home.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.home.model.entity.Category;
import com.jdc.home.model.repo.CategoryRepo;
import com.jdc.home.model.repo.CourseCodeGeneratorRepo;

@Service
@Transactional(readOnly = true)
public class CourseCodeGeneratingService {
	
	@Autowired
	private CourseCodeGeneratorRepo generatorRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Transactional
	public void next(int categoryId) {
		generatorRepo.findById(categoryId).ifPresent(g -> g.next());
	}
	
	private static final String COURSE_CODE_FORMAT = "%s%03d";
	
	public String getCourseCode(int categoryId) { 
		var categoryCodeAndCourseCount = generatorRepo.findCourseCountByCategoryId(categoryId);
		return COURSE_CODE_FORMAT.formatted(categoryCodeAndCourseCount.categoryCode(), categoryCodeAndCourseCount.courseCount());
	}
	
	@Transactional
	public String nextAndGetCourseCode(int categoryId) {
		var category = categoryRepo.findById(categoryId).orElseThrow();
		var courseCodeGenerator = category.getCourseCodeGenerator();
		courseCodeGenerator.next();
		return COURSE_CODE_FORMAT.formatted(category.getCategoryCode(), courseCodeGenerator.getCourseCount());
	}
	
	@Transactional
	public String nextAndGetCourseCode(Category category) {
		var courseCodeGenerator = category.getCourseCodeGenerator();
		courseCodeGenerator.next();
		return COURSE_CODE_FORMAT.formatted(category.getCategoryCode(), courseCodeGenerator.getCourseCount());
	}
		
}
