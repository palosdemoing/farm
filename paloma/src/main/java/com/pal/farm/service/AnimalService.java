package com.pal.farm.service;


import java.util.List;

import com.pal.farm.model.Animal;


public interface AnimalService extends CRUDService<Animal, Integer> {

	List<Animal> findByUser(Integer user);

	void update(Animal a);

	Animal findById(Integer id);

	List<Integer> getAllIds();

	List<Integer> getAllIdsByUserId(Integer user);

}
