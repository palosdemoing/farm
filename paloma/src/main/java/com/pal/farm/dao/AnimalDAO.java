package com.pal.farm.dao;


import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.Animal;


@Transactional
@Repository
public interface AnimalDAO extends PagingAndSortingRepository<Animal, Integer> {
	
//	@Query(value = "SELECT sum(amount) FROM account_transaction WHERE account_id = :accountId")
	// animales prolíficos... todas las producciones de cada uno then topN

}
