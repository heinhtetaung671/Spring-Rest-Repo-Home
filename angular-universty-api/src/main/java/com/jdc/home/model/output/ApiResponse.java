package com.jdc.home.model.output;

import java.time.LocalDateTime;

public record ApiResponse<T>(boolean success, LocalDateTime responseTime, T payload) {

	public static <T> ApiResponse<T> success(T payload) {
		return new ApiResponse<T>(true, LocalDateTime.now(), payload);
	}

	public static <T> ApiResponse<T> fail(T payload) {
		return new ApiResponse<T>(false, LocalDateTime.now(), payload);
	}

}
