package com.inl.oarch.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor(staticName = "of")
public class Car {
	
	@Getter
	private String identity;
	@Getter
	private String brand;
	@Getter
	private int mileage;
	@Getter
	private Set<Service> services;
}