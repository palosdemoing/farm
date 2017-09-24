package com.pal.farm.dao;


import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.Production;


@Repository
public interface ProductionDAO extends PagingAndSortingRepository<Production, Integer> {
	
	public Optional<Production> findOneByProductionDateAndAnimal(String date, String animal);

}
