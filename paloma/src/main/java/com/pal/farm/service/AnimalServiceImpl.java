package com.pal.farm.service;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.model.Animal;


@Service
public class AnimalServiceImpl implements AnimalService {
	
	@Autowired
	@Qualifier("AnimalDAO")
	private AnimalDAO animalDao;
	
	@Autowired
	private UserService userService;

	@Override
	public List<Animal> findByUser(String username) {
		// 		Integer idUser = userService.findByUsername(username).getIdUser();
		return animalDao.findByUser(username);		
	}

}
