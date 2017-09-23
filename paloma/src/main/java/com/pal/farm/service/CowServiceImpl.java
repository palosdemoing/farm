package com.pal.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.CowDAO;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Chicken;
import com.pal.farm.model.Cow;

@Service
public class CowServiceImpl implements CowService {

	@Autowired
	private CowDAO cowDao;

	@Override
	public Cow create(Cow t) {
		return cowDao.save(t);
	}

	@Override
	public void delete(Cow t) {
		cowDao.delete(t);
	}

	@Override
	public Cow update(Cow t) {
		return cowDao.save(t);
	}

	@Override
	public List<Cow> getAll(Pageable pageable) {
		final List<Cow> cows = new ArrayList<>();
		cowDao.findAll(pageable).forEach(c -> {
			if (c instanceof Cow) {
				cows.add( (Cow) c );
			}
		});
		return cows;
	}

	@Override
	public Cow findById(Integer id) {
		return (Cow) cowDao.findOne(id);
	}

	@Override
	public List<Cow> findByTypeAndFrecuency(String type, String frecuency) {
		return cowDao.findOneByTypeAndFrecuency(type, frecuency);		
	}
	
}
