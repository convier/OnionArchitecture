package com.inl.oarch.usecase.common;

import java.util.Date;

import com.inl.oarch.usecase.BusinessException;

public interface TechnicalService {
	
	void pass(String carIdentity, Date date) throws BusinessException;

}