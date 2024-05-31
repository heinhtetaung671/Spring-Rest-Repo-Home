package com.jdc.students.domain.account.entity;

import com.jdc.students.domain.AbstractEntity;
import com.jdc.students.domain.account.constant.AccountRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Account extends AbstractEntity{

	@Id
	private String code;
	
	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private AccountRole accountRole;
	
	private boolean activated;
	
}
