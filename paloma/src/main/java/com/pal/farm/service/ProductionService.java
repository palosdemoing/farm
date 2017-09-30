package com.pal.farm.service;


import java.util.Date;
import java.util.List;

import com.pal.farm.model.Production;


public interface ProductionService extends CRUDService<Production, Integer> {
	
//	List<Production> productionsBetweenDates (Date startDate, Date endsDate);

	List<Production> productionsByAnimal (Integer idAnimal);

}

