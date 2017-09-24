package com.pal.farm.dao;


import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pal.farm.model.Animal;


@NoRepositoryBean
public interface AnimalDAO extends PagingAndSortingRepository<Animal, Integer>  {

		// animales prolíficos... todas las producciones de cada uno then topN
	
}


