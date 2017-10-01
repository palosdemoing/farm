package com.pal.farm.controller;


import java.util.Date;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.AnimalProfitsDTO;
import com.pal.farm.dto.UserProfitsDTO;


public interface StatsController {

	List<AnimalProfitsDTO> profitsByAnimal(Integer n);
	
	List<UserProfitsDTO> profitsByUser(String name, Date startDate, Date endsDate) throws NotFound;

}
