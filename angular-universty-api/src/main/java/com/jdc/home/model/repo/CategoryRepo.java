package com.jdc.home.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.home.model.entity.Category;
import com.jdc.home.model.output.CategoryInfo;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	@Query("select new com.jdc.home.model.output.CategoryInfo(c.id, c.name) from Category c")
	List<CategoryInfo> searchAllCategories();
	
}
