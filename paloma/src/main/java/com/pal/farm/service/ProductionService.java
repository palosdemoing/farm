package com.pal.farm.service;


import java.util.Date;
import java.util.List;

import com.pal.farm.model.Production;


public interface ProductionService extends CRUDService<Production, Integer> {

	List<Production> productionsByAnimal (Integer idAnimal);

	Integer checkProductions(List<Production> productions);

	List<Production> productionsByAnimalAndRange(Integer id, Date startDate, Date endsDate);

}

