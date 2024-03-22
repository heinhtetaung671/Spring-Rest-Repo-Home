package com.jdc.payroll.model;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{

	private EntityManager em;

	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		em = entityManager;
	}

	@Override
	public <R> List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> searchFunc) {
		var cb = em.getCriteriaBuilder();
		var cq = searchFunc.apply(cb);
		
		return em.createQuery(cq).getResultList();
	}

	@Override
	public <R> Page<R> search(Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc,
			Function<CriteriaBuilder, CriteriaQuery<R>> searchFunc, int page, int pageSize) {
		var cb = em.getCriteriaBuilder();
		
		var countCriteriaQuery = countFunc.apply(cb);
		var searchCriteriaQuery = searchFunc.apply(cb);
		
		var count = em.createQuery(countCriteriaQuery).getSingleResult();
		var searchQuery = em.createQuery(searchCriteriaQuery);
		
		searchQuery.setFirstResult(page * pageSize);
		searchQuery.setMaxResults(pageSize);
		
		var pageRequest = PageRequest.of(page, pageSize);
		
		return new PageImpl<R>(searchQuery.getResultList(), pageRequest, count);
	}

	@Override
	public <R> R find(Function<CriteriaBuilder, CriteriaQuery<R>> searchFunc) {
		var cb = em.getCriteriaBuilder();
		var searchCriteriqQuery = searchFunc.apply(cb);
		
		return em.createQuery(searchCriteriqQuery).getSingleResult();
	}

}
