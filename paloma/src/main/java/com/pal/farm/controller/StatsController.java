package com.pal.farm.controller;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.AnimalProfitsDTO;
import com.pal.farm.dto.UserProfitsDTO;


public interface StatsController {

	List<AnimalProfitsDTO> profitsByAnimal(Integer n);
	
	public List<UserProfitsDTO> profitsByUser(String name) throws NotFound;

}
