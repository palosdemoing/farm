package com.pal.farm.dao;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pal.farm.model.Animal;


@NoRepositoryBean
public interface AnimalDAO extends PagingAndSortingRepository<Animal, Integer>  {
	
	public List<Animal> findOneByTypeAndFrecuency(String type, String frecuency);

}


