package com.inl.oarch.application;

import java.util.Date;

import com.inl.oarch.application.common.TechnicalService;
import com.inl.oarch.domain.model.Car;
import com.inl.oarch.domain.model.Service;
import com.inl.oarch.domain.service.CarRepository;
import com.inl.oarch.domain.service.ServiceRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class TechnicalServiceImpl implements TechnicalService {
	
	private CarRepository carDAO;
	
	private ServiceRepository serviceDAO;
	
	public void pass(@NonNull String carIdentity, @NonNull Date date) throws BusinessException {
		
		final Car car = carDAO.findBy(carIdentity).orElseThrow(() -> new BusinessException("Car isn't found, identity: "+ carIdentity));
		
		serviceDAO.save(Service.of(date, car));
	}	
}