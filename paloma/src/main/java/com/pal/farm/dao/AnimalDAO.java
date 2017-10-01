package com.pal.farm.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pal.farm.dto.AnimalProfitsDTO;
import com.pal.farm.model.Animal;


@Qualifier("AnimalDAO")
@Transactional
@Repository
public interface AnimalDAO extends PagingAndSortingRepository<Animal, Integer> {

	List<Animal> findByUser(String username); 
	
	@Query("select new AnimalProfitsDTO(a.type, sum(p.offerPrice - p.costPrice) as profits) " + 
			   "from Animal a inner join Production p group by a.idAnimal order by profits") 
	public List<AnimalProfitsDTO> profitsByAnimal(); // @Param("n") Integer n);
}
