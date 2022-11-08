package com.inl.oarch.dao;

import java.util.Optional;

import com.inl.oarch.model.Car;

public interface CarDAO {
	
	Optional<Car> findBy(String identity);
}