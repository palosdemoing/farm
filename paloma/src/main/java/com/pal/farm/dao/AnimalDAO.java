package com.pal.farm.dao;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pal.farm.model.Animal;
import com.pal.farm.model.Chicken;


@NoRepositoryBean
public interface AnimalDAO extends PagingAndSortingRepository<Animal, Integer>  {

}


