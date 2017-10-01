package com.pal.farm.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.Production;


@Repository
public interface ProductionDAO extends PagingAndSortingRepository<Production, Integer> {
	
	public List<Production> findAllByAnimal(Integer id);

	@Query("select p from Production p where (p.animal = :id) and (p.productionDate between :startDate and :endsDate)")
	public List<Production> productionsByAnimalAndRange(@Param("id") Integer id, @Param("startDate") Date startDate, @Param("endsDate") Date endsDate);
	
}
