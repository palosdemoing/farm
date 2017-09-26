package com.pal.farm.dto;


import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class TopNAnimalsProfitsDTO implements Serializable {
	
	private String user;
	
	private String animal;
	
	private String profits;

}
