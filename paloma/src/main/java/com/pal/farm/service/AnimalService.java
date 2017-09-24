package com.pal.farm.service;


import java.util.List;

import com.pal.farm.model.Animal;


public interface AnimalService {
	
	public List<Animal> findByUser(String username);

}
