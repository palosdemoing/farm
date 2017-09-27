package com.pal.farm.dto;


import java.io.Serializable;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ProductionDTO implements Serializable {

	private static final long serialVersionUID = 9116134377449156831L;
	
	private Date date;

	private Boolean state;

	private Double costPrice;

	private Double offerPrice;

	private Integer animal;

}
