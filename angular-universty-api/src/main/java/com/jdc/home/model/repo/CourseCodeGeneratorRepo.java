package com.jdc.home.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.home.model.dto.CategoryCodeAndCourseCountDto;
import com.jdc.home.model.entity.CourseCodeGenerator;

public interface CourseCodeGeneratorRepo extends JpaRepository<CourseCodeGenerator, Integer>{

	@Query(value = "select new com.jdc.home.model.dto.CategoryCodeAndCourseCountDto(c.categoryCode, cc.courseCount) from CourseCodeGenerator cc join Category c on c.id = cc.id where cc.category.id = ?1")
	public CategoryCodeAndCourseCountDto findCourseCountByCategoryId(int categoryId);
	
}
