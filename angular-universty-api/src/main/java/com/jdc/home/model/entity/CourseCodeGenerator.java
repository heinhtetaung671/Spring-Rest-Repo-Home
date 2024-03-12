package com.jdc.home.model.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CourseCodeGenerator {

	@Id
	private int id;
	@ColumnDefault(value = "0")
	private int courseCount;

	@MapsId
	@OneToOne(optional = false)
	private Category category;
	
	public void next() {
		courseCount++;
	}
}
