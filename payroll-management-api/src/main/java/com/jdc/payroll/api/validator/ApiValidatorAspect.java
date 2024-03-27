package com.jdc.payroll.api.validator;

import java.util.stream.Collectors;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.jdc.payroll.model.exception.ValidationException;

@Component
@Aspect
public class ApiValidatorAspect {

	@Pointcut(value = "(org.springframework.web.bind.annotation.RestController) && args(.., result)")
	public void apiMethods() {
	}

	@Before(value = "apiMethods()", argNames = "result")
	public void validate(BindingResult result) {
		if (result.hasErrors()) {
			throw new ValidationException(result.getFieldErrors().stream()
					.collect(Collectors.toMap(fe -> fe.getField(), fe -> fe.getDefaultMessage())));
		}
	}

}
