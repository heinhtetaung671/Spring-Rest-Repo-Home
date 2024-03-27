package com.jdc.payroll.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.payroll.api.input.DepartmentCreateForm;
import com.jdc.payroll.api.input.DepartmentSearchForm;
import com.jdc.payroll.api.output.DepartmentInfo;
import com.jdc.payroll.model.ApiResponse;
import com.jdc.payroll.model.DataModificationResult;
import com.jdc.payroll.model.service.DepartmentService;

@RestController
@RequestMapping("api/department")
public class DepartmentApi {

	@Autowired
	private DepartmentService service;
	
	@PostMapping
	ApiResponse<DataModificationResult<String>> create(@RequestBody @Validated DepartmentCreateForm form, BindingResult result) {
		return ApiResponse.success(service.create(form));
	}
	
	ApiResponse<List<DepartmentInfo>> search(DepartmentSearchForm form){
		return ApiResponse.success(service.search(form));
	}

}
