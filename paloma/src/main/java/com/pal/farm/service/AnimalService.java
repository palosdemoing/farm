package com.pal.farm.service;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Production;


public interface AnimalService { // extends CRUDService<Chicken, Integer> {
	
	public List<Animal> findByUser(String username);

	public void update(Animal a);

	Animal findById(Integer id);

}
