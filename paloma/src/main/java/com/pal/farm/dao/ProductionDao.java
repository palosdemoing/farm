package com.pal.farm.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.Production;

@Repository
public interface ProductionDao extends PagingAndSortingRepository<Production, Integer> {
	
	public Optional<Production> findOneByProductionDateAndChicken(String date, String chicken);

}
