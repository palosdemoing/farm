package com.pal.farm.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.Cow;

@Repository
public interface CowDao extends PagingAndSortingRepository<Cow, Integer> {
	
	public List<Cow> findOneByTypeAndFrecuency(String type, String frecuency);

}
