package com.pal.farm.dto;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class AnimalProfitsDTO implements Serializable {

	private static final long serialVersionUID = 8920720499595714726L;
	
	private String animalType;
	
	private Double profits;

}
