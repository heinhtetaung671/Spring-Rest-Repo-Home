package com.jdc.home.model.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course extends AbstractEntity {

	@Id
	private String id;
	@Column(length = 45)
	private String name;
	@Column(nullable = false)
	@ColumnDefault(value = "0")
	private int fees;
	@Column(nullable = false)
	@ColumnDefault(value = "0")
	private short duration;
	private String description;
	
	@ManyToOne(optional = false)
	private Category category;
	

}
