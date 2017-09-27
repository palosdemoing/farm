package com.pal.farm.dao;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.Production;


@Repository
public interface ProductionDAO extends PagingAndSortingRepository<Production, Integer> {
	
	public List<Production> findAllByAnimal(String date, String animal);

}
