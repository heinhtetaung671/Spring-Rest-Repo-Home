package com.jdc.payroll.api.output;

import com.jdc.payroll.model.entity.Department;
import com.jdc.payroll.model.entity.Department_;
import com.jdc.payroll.model.entity.Employee_;
import com.jdc.payroll.model.entity.Position_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public record DepartmentInfo(int id, String code, String name, String headOfDepartment, String phone, String email, String desc,
		long positionCount, long employeeCount) {

	public static void select(CriteriaBuilder cb, CriteriaQuery<DepartmentInfo> cq, Root<Department> root) {
		
		var employee = root.join(Department_.headOfDepartment, JoinType.LEFT);
		var positions = root.join(Department_.positions, JoinType.LEFT);
		var employees = root.join(Department_.positions, JoinType.LEFT).join(Position_.employees, JoinType.LEFT);
		
		cq.multiselect(
				root.get(Department_.id),
				root.get(Department_.code),
				root.get(Department_.name),
				cb.coalesce(employee.get(Employee_.name), null),
				root.get(Department_.phone),
				root.get(Department_.email),
				root.get(Department_.desc),
				cb.count(positions.get(Position_.id)),
				cb.count(employees.get(Employee_.id))
				);
		
		cq.groupBy(
				root.get(Department_.id),
				root.get(Department_.code),
				root.get(Department_.name),
				cb.coalesce(employee.get(Employee_.name), null),
				root.get(Department_.phone),
				root.get(Department_.email),
				root.get(Department_.desc));
	}

}
