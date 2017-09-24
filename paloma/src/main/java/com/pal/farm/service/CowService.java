package com.pal.farm.service;

import java.util.List;

import com.pal.farm.controller.CRUD;
import com.pal.farm.dto.CowDTO;

public interface CowService extends CRUD<CowDTO, Integer> {
	
	public List<CowDTO> findByTypeAndFrecuency(String type, String frecuency);

}
