package com.pal.farm.controller;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.AnimalDTO;
import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.dto.UserDTO;


public interface UserController extends CRUDController <UserDTO, String>{
	
	UserDTO findByUsername(String name) throws NotFound;

	List<AnimalDTO> findAnimalsByUsername(String name) throws NotFound;

	List<ProductionDTO> findAnimalProductionByUsername(String name, Integer id) throws NotFound;

}