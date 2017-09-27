package com.pal.farm.dto;


import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ChickenDTO implements Serializable {

	private static final long serialVersionUID = 8267429937399245784L;

	private String type;

	private String frecuency;
	
	private List<String> productions;

}
