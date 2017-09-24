package com.pal.farm.service;


import java.util.List;

import com.pal.farm.controller.CRUD;
import com.pal.farm.dto.ChickenDTO;

public interface ChickenService extends CRUD<ChickenDTO, Integer> {
	
	public List<ChickenDTO> findByTypeAndFrecuency(String type, String frecuency);

}
