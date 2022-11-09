package com.inl.oarch.application;

public class BusinessException extends Throwable {
	
	private static final long serialVersionUID = -375706226071611979L;

	public BusinessException(String message) {
		super(message);
	}
}
