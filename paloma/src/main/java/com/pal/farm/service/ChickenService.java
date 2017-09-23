package com.pal.farm.service;


import java.util.List;

import com.pal.farm.controller.CRUD;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Chicken;

public interface ChickenService extends CRUD<Chicken, Integer> {
	
	public List<Chicken> findByTypeAndFrecuency(String type, String frecuency);

}
