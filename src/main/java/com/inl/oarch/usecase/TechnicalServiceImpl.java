package com.inl.oarch.usecase;

import java.util.Date;

import com.inl.oarch.dao.CarDAO;
import com.inl.oarch.dao.ServiceDAO;
import com.inl.oarch.model.Car;
import com.inl.oarch.model.Service;
import com.inl.oarch.usecase.common.TechnicalService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class TechnicalServiceImpl implements TechnicalService {
	
	private CarDAO carDAO;
	
	private ServiceDAO serviceDAO;

	public void pass(@NonNull String carIdentity, @NonNull Date date) throws BusinessException {
		
		final Car car = carDAO.findBy(carIdentity).orElseThrow(() -> new BusinessException("Car isn't found, identity: "+ carIdentity));
		
		serviceDAO.save(Service.of(date, car));
	}
}
