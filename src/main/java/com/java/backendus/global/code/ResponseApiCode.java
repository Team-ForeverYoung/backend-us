package com.java.backendus.global.code;

import org.springframework.http.HttpStatus;

public interface ResponseApiCode {
	HttpStatus getStatus();
	String getCode();
	String getMessage();
}