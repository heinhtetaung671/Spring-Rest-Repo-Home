package com.jdc.payroll.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee extends AbstractEntity{

	public static final String EMPLOYEE_CODE_FORMAT = "%s%03d";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false)
	private String code;
	private String name;

	@JoinColumn(name = "password_id")
	@OneToOne(optional = false)
	private Password password;

	@ElementCollection
	@JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = "phones"))
	private List<String> phones;
	@ElementCollection
	@JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = "emails"))
	private List<String> emails;

	@ManyToOne
	private Position position;

}
