package com.pal.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.CowDao;
import com.pal.farm.model.Cow;

@Service
public class CowServiceImpl implements CowService {

	@Autowired
	private CowDao dao;

	@Override
	public Cow create(Cow t) {
		return dao.save(t);
	}

	@Override
	public void delete(Cow t) {
		dao.delete(t);
	}

	@Override
	public Cow update(Cow t) {
		return dao.save(t);
	}

	@Override
	public List<Cow> getAll(Pageable pageable) {
		final List<Cow> cows = new ArrayList<>();
		dao.findAll(pageable).forEach(c -> cows.add(c));
		return cows;
	}

	@Override
	public Cow findById(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public List<Cow> findByTypeAndFrecuency(String type, String frecuency) {
		return dao.findOneByTypeAndFrecuency(type, frecuency);		
	}
	
}
