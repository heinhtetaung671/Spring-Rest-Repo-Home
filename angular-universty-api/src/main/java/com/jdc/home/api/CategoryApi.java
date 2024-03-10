package com.jdc.home.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.home.model.output.ApiResponse;
import com.jdc.home.model.output.CategoryInfo;
import com.jdc.home.model.service.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryApi {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("search")
	ApiResponse<List<CategoryInfo>> search(){
		return ApiResponse.success(categoryService.searchAllCategories());
	}
	
}
