package com.pal.farm.service;


import java.util.List;

import com.pal.farm.model.Chicken;

public interface ChickenService extends CRUDService<Chicken, Integer> {
	
	public List<Chicken> findByTypeAndFrecuency(String type, String frecuency);

}
