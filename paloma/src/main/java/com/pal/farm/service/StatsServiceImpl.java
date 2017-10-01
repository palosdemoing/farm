package com.pal.farm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.dto.AnimalProfitsDTO;
import com.pal.farm.dto.UserProfitsDTO;


@Service
public class StatsServiceImpl implements StatsService {

	@Autowired
	private UserService userService;

	@Autowired 
	public AnimalService animalService;

	@Autowired
	private ProductionService productionService;

	@Autowired
	private AnimalDAO animalDao;
	

	@Override
	public List<AnimalProfitsDTO> profitsByAnimal() { //Integer n){
		// get all animal con productions <> de null
		// get productions de animal y restar el cost al offer almacenando en DTO para toda producción
		// ordenar lista por campo profit
		// devolver N primeros
		List<AnimalProfitsDTO> resultSet = new ArrayList<>();
//		animalDao.profitsByAnimal().forEach(o -> {
//			resultSet.add( new AnimalProfitsDTO((String) o[0], (Double) o[1]) );			
//		});
		return animalDao.profitsByAnimal(); // n);
	}
//
//	@Override
//	public List<UserProfitsDTO> profitsByUser(String name, Date startDate, Date endsDate){
//		// get all animals de user con productions <> de null
//		// acumula todas las rpoductions entre las fichas dadas
//		// get productions de animal y restar el cost al offer almacenando en DTO para toda producción
//		// ordenar lista por campo profit
//		// devolver N primeros
//		return statsDao.profitsByUser(name, startDate, endsDate);
//	}

}
