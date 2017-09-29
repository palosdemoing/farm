package com.pal.farm.service;

import java.util.List;

import com.pal.farm.dto.CowDTO;

public interface CowService extends CRUDService<CowDTO, Integer> {
	
	public List<CowDTO> findByTypeAndFrecuency(String type, String frecuency);

}
