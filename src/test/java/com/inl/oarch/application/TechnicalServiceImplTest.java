package com.inl.oarch.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.inl.oarch.application.common.TechnicalService;
import com.inl.oarch.domain.model.Car;
import com.inl.oarch.domain.model.Service;
import com.inl.oarch.domain.service.CarRepository;
import com.inl.oarch.domain.service.ServiceRepository;

public class TechnicalServiceImplTest {

	private CarRepository carDAO;
	private ServiceRepository serviceDAO;
	private TechnicalService technicalService;
	
	@BeforeEach
	public void setUp() {
		carDAO = mock(CarRepository.class);
		serviceDAO = mock(ServiceRepository.class);
		technicalService = new TechnicalServiceImpl(carDAO, serviceDAO);
	}

	@Test
	public void shouldPassService() throws BusinessException {

		when(carDAO.findBy(anyString())).thenReturn(Optional.of(Car.of("", "", 0, new HashSet<>())));
		doAnswer(v -> {
			return null;
		}).when(serviceDAO).save(any(Service.class));

		technicalService.pass("anyIdentity", new Date());

		verify(carDAO, atMostOnce()).findBy(anyString());
		verify(serviceDAO, atMostOnce()).save(any(Service.class));
	}

	@Test
	public void shouldThrowExceptionOnCarIsntFound() {
		when(carDAO.findBy(anyString())).thenReturn(Optional.empty());
		
		BusinessException thrown = assertThrows(BusinessException.class, () -> {			
			technicalService.pass("anyIdentity", new Date());
		});
		
		verify(carDAO, atMostOnce()).findBy(anyString());
		
	assertNotNull(thrown.getMessage());
	}

}
