package com.inl.oarch.usecase;

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

import com.inl.oarch.dao.CarDAO;
import com.inl.oarch.dao.ServiceDAO;
import com.inl.oarch.model.Car;
import com.inl.oarch.model.Service;
import com.inl.oarch.usecase.common.TechnicalService;

public class TechnicalServiceImplTest {

	private CarDAO carDAO;
	private ServiceDAO serviceDAO;

	private TechnicalService technicalService;
	
	@BeforeEach
	public void setUp() {
		carDAO = mock(CarDAO.class);
		serviceDAO = mock(ServiceDAO.class);
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
