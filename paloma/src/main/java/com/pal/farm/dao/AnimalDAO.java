package com.pal.farm.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.Animal;

@Transactional
@Repository
public interface AnimalDAO extends PagingAndSortingRepository<Animal, Integer> {

	// animales prolíficos... todas las producciones de cada uno then topN

}
