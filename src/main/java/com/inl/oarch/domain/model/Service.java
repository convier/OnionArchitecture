package com.inl.oarch.domain.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor(staticName = "of")
public class Service {
	
	@Getter
	private Date date;
	
	@Getter
	private Car car;

}
