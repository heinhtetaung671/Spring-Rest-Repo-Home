package com.jdc.payroll.api.input;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.payroll.model.entity.Department;
import com.jdc.payroll.model.entity.Department_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record DepartmentSearchForm(String code, String name, String phone, String email) {
	
	public Predicate[] where(CriteriaBuilder cb, Root<Department> root){
		var list = new ArrayList<Predicate>();
		
		if(StringUtils.hasLength(code)) {
			list.add(cb.equal(cb.lower(root.get(Department_.code)), code.toLowerCase()));
		}
		
		if(StringUtils.hasLength(name)) {
			list.add(cb.like(cb.lower(root.get(Department_.name)), name.toLowerCase().concat("%")));
		}
		
		if(StringUtils.hasLength(phone)) {
			list.add(cb.like(cb.lower(root.get(Department_.phone)), phone.toLowerCase().concat("%")));
		}
		
		if(StringUtils.hasLength(email)) {
			list.add(cb.like(cb.lower(root.get(Department_.email)), email.toLowerCase().concat("%")));
		}
		
		return list.toArray(size -> new Predicate[size]);
	}
	
}
