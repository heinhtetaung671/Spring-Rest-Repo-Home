package com.jdc.payroll.model;

public record DataModificationResult<T>(T code, String message) {

	public static <T> DataModificationResult<T> updateResult(T code, String domainName, String fieldName){
		return new DataModificationResult<T>(code, "%s has been updated with %s %s".formatted(domainName, fieldName, code));
	}
	
	public static <T> DataModificationResult<T> createResult(T code, String domainName, String fieldName){
		return new DataModificationResult<T>(code, "%s has been created with %s %s".formatted(domainName, fieldName, code));
	}
	
}
