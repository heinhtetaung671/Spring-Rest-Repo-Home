package com.jdc.students.domain.account.entity;

import com.jdc.students.domain.AbstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class LoginUser extends AbstractEntity{

	@Id
	private String code;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "code")
	private Account account;
	
	@Column(unique = true)
	private String phone;
	@Column(unique = true)
	private String email;
	
}
