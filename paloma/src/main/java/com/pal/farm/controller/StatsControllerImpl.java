package com.pal.farm.controller;

import java.util.Date;
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
	
	
	@RequestMapping(value = "/production/topanimals/{n}", method = RequestMethod.GET)
	public List<AnimalProfitsDTO> profitsByAnimal(@RequestParam(name = "n", required = false, defaultValue="5") Integer n){
		return statsService.profitsByAnimal(n);
	}
	
	@RequestMapping(value = "/profits/{name}", method = RequestMethod.GET)
	public UserProfitsDTO profitsByUser(@PathVariable("name") String name, 
										@RequestParam(name = "from", required = false, defaultValue="01/01/1900") Date startDate, 
										@RequestParam(name = "to", required = false, defaultValue="31/12/2200") Date endsDate) throws NotFound {
		return statsService.profitsByUser(name, startDate, endsDate);
	}
}
