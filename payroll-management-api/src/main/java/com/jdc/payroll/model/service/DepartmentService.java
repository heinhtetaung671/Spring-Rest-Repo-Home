package com.jdc.payroll.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.payroll.api.input.DepartmentCreateForm;
import com.jdc.payroll.model.DataModificationResult;
import com.jdc.payroll.model.repo.DepartmentRepo;

@Service
@Transactional
public class DepartmentService {

	@Autowired
	private DepartmentRepo repo;
	
	private static final String DOMAIN_NAME	= "Department";

	public DataModificationResult<String> create(DepartmentCreateForm form) {
		var entity = repo.save(form.entity());
		return DataModificationResult.createResult(entity.getCode(), DOMAIN_NAME, "code");
	}
}
