package com.jdc.home.model.output;

public record DataModificationResult<T>(T id, String message) {

	public static <T> DataModificationResult<T> updateResult(T id, String domainName, String idFieldName){
		return new DataModificationResult<T>(id, "%s has been updated with %s %s".formatted(domainName, idFieldName, id));
	}
	
	public static <T> DataModificationResult<T> createResult(T id, String domainName, String idFieldName){
		return new DataModificationResult<T>(id, "%s has been created with %s %s".formatted(domainName, idFieldName, id));
	}
}
