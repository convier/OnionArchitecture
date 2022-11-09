package com.inl.oarch.adapter.rest;

import com.inl.oarch.application.BusinessException;
import com.inl.oarch.application.common.TechnicalService;

public class TechnicalServiceREST {

	private TechnicalService technicalService;

	public void pass(String carIdentifier, String serviceDate) {
		try {
			technicalService.pass(carIdentifier, null);
		} catch (BusinessException e) {
			System.err.println("We can't pass service. " + e.getMessage());
		}
	}

}
