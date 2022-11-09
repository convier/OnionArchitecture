package com.inl.oarch.domain.service;

import java.util.Optional;

import com.inl.oarch.domain.model.Car;

public interface CarRepository {
	
	Optional<Car> findBy(String identity);
}