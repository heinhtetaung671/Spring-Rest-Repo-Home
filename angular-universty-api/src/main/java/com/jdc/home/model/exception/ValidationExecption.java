package com.jdc.home.model.exception;

import java.util.Map;

public class ValidationExecption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private Map<String, String> errorMap;
	
	public ValidationExecption(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}
	
	public Map<String, String> getErrorMap() {
		return errorMap;
	}
}
