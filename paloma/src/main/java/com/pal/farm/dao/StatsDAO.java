package com.pal.farm.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pal.farm.dto.AnimalProfitsDTO;
import com.pal.farm.dto.UserProfitsDTO;
import com.pal.farm.model.Animal;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Repository
public interface StatsDAO extends PagingAndSortingRepository<Object, Integer> {

	@Query(value = "select new AnimalProfitsDTO(a.type, sum(p.offerPrice - p.costPrice) as profits) " +
				   "from Animal a inner join Production p group by a.idAnimal order by profits")   //  where a.idAnimal=p.animal
	public List<AnimalProfitsDTO> profitsByAnimal(); // @Param("n") Integer n);

//	List<UserProfitsDTO> profitsByUser(String name, Date startDate, Date endsDate);


//	@Query(value = "select new AnimalProfitsDTO(u.id, u.dni, u.name) from User as u where (:name is null OR u.name like %:name%) AND (:dni is null OR u.dni like %:dni%)")
//	List<AnimalProfitsDTO> orderByAnimalProfits(@Param(value = "n") String n);
	

	
//	@Query("SELECT p FROM Production p WHERE p.production_date BETWEEN :from AND :to AND p.user = :username")
//	public List<Production> findProductionsByUserAndDateRange(
////	    @Param("from") @Temporal(TemporalType.TIMESTAMP) Date startDay,
////	    @Param("to") @Temporal(TemporalType.TIMESTAMP) Date endDay,
//	    @Param("username") String username
//	);
}