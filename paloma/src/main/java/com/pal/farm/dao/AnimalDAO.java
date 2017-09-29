package com.pal.farm.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.Animal;


@Qualifier("AnimalDAO")
@Transactional
@Repository
public interface AnimalDAO extends PagingAndSortingRepository<Animal, Integer> {

	List<Animal> findByUser(String username);  // 	Integer idUser = userService.findByUsername(username).getIdUser();
	
//	@Query(value = "SELECT sum(amount) FROM account_transaction WHERE account_id = :accountId")
	// animales prolíficos... todas las producciones de cada uno then topN

}
