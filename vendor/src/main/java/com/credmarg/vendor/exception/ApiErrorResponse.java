package com.credmarg.vendor.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiErrorResponse {
	
	private int statusCode;
    private String message;
    private long timestamp;

    public ApiErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

}
