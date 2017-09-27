package com.pal.farm.dto;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class TopNAnimalsProfitsDTO implements Serializable {

	private static final long serialVersionUID = 8920720499595714726L;

	private String user;

	private String animalClass;
	
	private String animalType;
	
	private String profits;

}
