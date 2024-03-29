package com.jdc.payroll.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PositionPasswordPolicy extends AbstractEntity{

	@Id
	private int id;
	
	@OneToOne
	@MapsId
	private Position position;
	
	@ManyToOne(optional = false)
	private PasswordPolicy passwordPolicy;
	
}
