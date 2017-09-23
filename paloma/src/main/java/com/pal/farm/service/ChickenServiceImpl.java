package com.pal.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ChickenDao;
import com.pal.farm.model.Chicken;

@Service
public class ChickenServiceImpl implements ChickenService {

	@Autowired
	private ChickenDao dao;

	@Override
	public Chicken create(Chicken t) {
		return dao.save(t);
	}

	@Override
	public void delete(Chicken t) {
		dao.delete(t);
	}

	@Override
	public Chicken update(Chicken t) {
		return dao.save(t);
	}

	@Override
	public List<Chicken> getAll(Pageable pageable) {
		final List<Chicken> chickens = new ArrayList<>();
		dao.findAll(pageable).forEach(c -> chickens.add(c));
		return chickens;
	}

	@Override
	public Chicken findById(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public List<Chicken> findByTypeAndFrecuency(String type, String frecuency) {
		return dao.findOneByTypeAndFrecuency(type, frecuency);		
	}
	
}
