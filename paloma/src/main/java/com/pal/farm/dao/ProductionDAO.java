package com.pal.farm.dao;


import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.Production;


@Repository
public interface ProductionDAO extends PagingAndSortingRepository<Production, Integer> {
	
	public List<Production> findAllByAnimal(Integer id);
	
	@Query("SELECT p FROM Production p WHERE p.production_date BETWEEN :from AND :to AND p.user = :username")
	public List<Production> findProductionsByUserAndDateRange(
//	    @Param("from") @Temporal(TemporalType.TIMESTAMP) Date startDay,
//	    @Param("to") @Temporal(TemporalType.TIMESTAMP) Date endDay,
	    @Param("username") String username
	);
	
	@Query("SELECT p FROM Production p WHERE p.production_date BETWEEN :from AND :to AND p.user = :username")
	public List<Production> productionsBetweenDates(Date startDate, Date endsDate);
	
}
