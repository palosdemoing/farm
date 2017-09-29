package com.pal.farm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dao.UserDAO;
import com.pal.farm.dto.AnimalProfitsDTO;
import com.pal.farm.dto.UserProfitsDTO;


@Service
public class StatsServiceImpl implements StatsService {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private AnimalDAO animalDao;

	@Autowired
	private ProductionDAO productionDao;
	
	public List<AnimalProfitsDTO> profitsByAnimal(Integer n){
		return null;
	}

	public List<UserProfitsDTO> profitsByUser(String name){
		return null;
	}

}
