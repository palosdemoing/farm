package com.pal.farm.service;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.model.Animal;


@Service
public class AnimalServiceImpl implements AnimalService {
	
//	@Autowired
//	private AnimalDAO animalDao;

	@Override
	public List<Animal> findByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public List<Animal> findByUser(String username) {
//		return animalDao.findByUser(username);		
//	}

}
