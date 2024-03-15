package com.jdc.payroll.model;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepositoryImplementation<T, ID> {

	<R> List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> searchFunc);
	
	<R> Page<R> search(Function<CriteriaBuilder, CriteriaQuery<Long>> countFunction, Function<CriteriaBuilder, CriteriaQuery<R>> searchFunc, int page, int pageSize);
	
	<R> R find(Function<CriteriaBuilder, CriteriaQuery<R>> searchFunc);
}
