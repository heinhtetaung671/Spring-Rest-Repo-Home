package com.jdc.home.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.home.model.input.CourseForm;
import com.jdc.home.model.output.ApiResponse;
import com.jdc.home.model.output.DataModificationResult;
import com.jdc.home.model.service.CourseService;

@RestController
@RequestMapping("api/course")
public class CourseApi {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("save")
	ApiResponse<DataModificationResult<String>> save(@RequestBody @Validated CourseForm form, BindingResult result){
		return ApiResponse.success(courseService.save(form));
	}
	
}
