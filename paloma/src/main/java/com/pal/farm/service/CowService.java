package com.pal.farm.service;

import java.util.List;

import com.pal.farm.controller.CRUD;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Cow;

public interface CowService extends CRUD<Cow, Integer> {
	
	public List<Cow> findByTypeAndFrecuency(String type, String frecuency);

}
