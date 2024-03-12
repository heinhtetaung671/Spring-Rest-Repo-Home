package com.jdc.home.api.exceptionHandler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.home.model.exception.ValidationExecption;
import com.jdc.home.model.output.ApiResponse;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler
	public ApiResponse<Map<String, String>> handleValidationException(ValidationExecption e){
		return ApiResponse.fail(e.getErrorMap());
	}
	
}
