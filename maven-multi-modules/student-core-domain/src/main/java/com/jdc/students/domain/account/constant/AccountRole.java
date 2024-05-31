package com.jdc.students.domain.account.constant;

public enum AccountRole {

	Admin("ADM"), Student("STD"), Teacher("TCR"), OfficeStaff("OFS");
	
	private String shortCode;
	
	public String getShortCode() {
		return shortCode;
	}
	
	private AccountRole(String shortCode) {
		this.shortCode = shortCode;
	}
	
}
