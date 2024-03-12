package com.jdc.home.aop;

import java.util.stream.Collectors;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.jdc.home.model.exception.ValidationExecption;

@Aspect
@Component
public class ApiMethodArgValidatingAop {

	@Pointcut(value = "@within(org.springframework.web.bind.annotation.RestController) ")
	public void apiMethods() {	}
	
	@Before(value = "apiMethods() && args(.., result)", argNames = "result")
	public void handle(BindingResult result) {
		if(result.hasErrors()) {
			throw new ValidationExecption(result.getFieldErrors().stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage())));
		}
	}
	
}
