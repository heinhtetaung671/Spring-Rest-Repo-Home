package com.jdc.payroll.model.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.payroll.api.input.DepartmentCreateForm;
import com.jdc.payroll.api.input.DepartmentSearchForm;
import com.jdc.payroll.api.output.DepartmentInfo;
import com.jdc.payroll.model.DataModificationResult;
import com.jdc.payroll.model.entity.Department;
import com.jdc.payroll.model.repo.DepartmentRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

	@Autowired
	private DepartmentRepo repo;

	private static final String DOMAIN_NAME = "Department";

	@Transactional
	public DataModificationResult<String> create(DepartmentCreateForm form) {
		var entity = repo.save(form.entity());
		return DataModificationResult.createResult(entity.getCode(), DOMAIN_NAME, "code");
	}

	public List<DepartmentInfo> search(DepartmentSearchForm form) {
		return repo.search(searchFunc(form));
	}

	private Function<CriteriaBuilder, CriteriaQuery<DepartmentInfo>> searchFunc(DepartmentSearchForm form) {
		return cb -> {
			var cq = cb.createQuery(DepartmentInfo.class);
			var root = cq.from(Department.class);
			DepartmentInfo.select(cb, cq, root);
			cq.where(form.where(cb, root));
			return cq;
		};
	}

}
