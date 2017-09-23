package com.pal.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.dao.ChickenDAO;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Chicken;

@Service
public class ChickenServiceImpl implements ChickenService {
//
//	@Autowired
//	private AnimalDAO animalDao;
	@Autowired
	private ChickenDAO chickenDao;

	@Override
	public Chicken create(Chicken t) {
		return chickenDao.save(t);
	}

	@Override
	public void delete(Chicken t) {
		chickenDao.delete(t);
//		animalDao.delete(t);
	}

	@Override
	public Chicken update(Chicken t) {
		return chickenDao.save(t);
	}

	@Override
	public List<Chicken> getAll(Pageable pageable) {
		final List<Chicken> chickens = new ArrayList<>();
		chickenDao.findAll(pageable).forEach(c -> chickens.add( (Chicken) c ));
		return chickens;
	}

	@Override
	public Chicken findById(Integer id) {
		return (Chicken) chickenDao.findOne(id);
	}

	@Override
	public List<Animal> findByTypeAndFrecuency(String type, String frecuency) {
		return chickenDao.findOneByTypeAndFrecuency(type, frecuency);		
	}
	
}
