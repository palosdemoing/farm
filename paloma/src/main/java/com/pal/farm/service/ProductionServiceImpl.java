package com.pal.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.model.Production;

@Service
public class ProductionServiceImpl implements ProductionService {

	@Autowired
	private ProductionDAO dao;

	@Override
	public Production create(Production t) {
		return dao.save(t);
	}

	@Override
	public void delete(Production t) {
		dao.delete(t);
	}

	@Override
	public Production update(Production t, Integer id) {
		return dao.save(t);
	}

	@Override
	public List<Production> getAll(Pageable pageable) {
		final List<Production> productions = new ArrayList<>();
		dao.findAll(pageable).forEach(p -> productions.add(p));
		return productions;
	}

	@Override
	public Production findById(Integer id) {
		return dao.findOne(id);
	}

}