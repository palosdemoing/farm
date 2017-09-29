package com.pal.farm.controller;

import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pal.farm.dto.AnimalProfitsDTO;
import com.pal.farm.dto.UserProfitsDTO;
import com.pal.farm.service.StatsService;

@RestController
@RequestMapping(value = "/stats")
public class StatsControllerImpl {

	@Autowired
	private StatsService statsService;
	
	
	@RequestMapping(value = "/profits/topAnimals/{n}", method = RequestMethod.GET)
	List<AnimalProfitsDTO> profitsByAnimal(@RequestParam("n") Integer n){
		return statsService.profitsByAnimal(n);
	}
	
	@RequestMapping(value = "/profits/{name}", method = RequestMethod.GET)
	public List<UserProfitsDTO> profitsByUser(@PathVariable("name") String name) throws NotFound {
		return statsService.profitsByUser(name);
	}
}
