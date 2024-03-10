package com.jdc.home.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.home.model.output.CategoryInfo;
import com.jdc.home.model.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo repo;
	
	public List<CategoryInfo> searchAllCategories(){
		return repo.searchAllCategories();
	}
	
}
