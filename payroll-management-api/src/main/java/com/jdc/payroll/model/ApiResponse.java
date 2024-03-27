package com.jdc.payroll.model;

import java.time.LocalDateTime;

public record ApiResponse<T>(Status status, LocalDateTime responseTime, T payload) {

	public static <T> ApiResponse<T> success(T payload){
		return new ApiResponse<T>(Status.SUCCESS, LocalDateTime.now(), payload);
	}

}

