package com.inl.oarch.application.common;

import java.util.Date;

import com.inl.oarch.application.BusinessException;

public interface TechnicalService {
	
	void pass(String carIdentity, Date date) throws BusinessException;

}