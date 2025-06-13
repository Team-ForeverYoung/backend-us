package com.java.backendus.domain.member;

import org.springframework.http.HttpStatus;

import com.java.backendus.global.code.ResponseApiCode;

public enum MemberCode implements ResponseApiCode {

	USER_POINT_SAVE_SUCCESS(HttpStatus.OK,"u001","포인트 적립이 성공적으로 완료되었습니다."),
	USER_POINT_CHECK_SUCCESS(HttpStatus.OK,"u002","포인트 조회가 성공적으로 완료되었습니다."),
	;

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;

	MemberCode(HttpStatus httpStatus, String code, String message) {
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
	}

	@Override
	public HttpStatus getStatus() {
		return httpStatus;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
