package com.jdc.home.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true, length = 45)
	private String name;
	@Column(nullable = false, length = 3, unique = true)
	private String categoryCode;
	
	@OneToOne(mappedBy = "category", optional = false)
	private CourseCodeGenerator courseCodeGenerator;
	
}
