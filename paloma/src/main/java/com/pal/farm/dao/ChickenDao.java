package com.pal.farm.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.Chicken;

@Repository
public interface ChickenDao extends PagingAndSortingRepository<Chicken, Integer> {
	
	public List<Chicken> findOneByTypeAndFrecuency(String type, String frecuency);

}
