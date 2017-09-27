package com.pal.farm.service;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ChickenDAO;
import com.pal.farm.model.Chicken;


@Service
public class ChickenServiceImpl implements ChickenService {
	
	@Autowired
	private ChickenDAO chickenDao;

	@Override
	public Chicken create(Chicken c) {
		return chickenDao.save(c);	
	}

	@Override
	public void delete(Chicken t) throws CannotProceed{
//		chickenDao.delete(c);  // error 401
		throw new CannotProceed();
	}

	@Override
	public void update(Chicken c) throws NotFound {
//		if ( findById(c.getIdAnimal()) instanceof Chicken ) {
//			throw new NotFound();
//		}
		chickenDao.save(c);
	}

	@Override
	public List<Chicken> getAll(Pageable pageable) throws CannotProceed {
		if (pageable.getPageSize() > 10) {
			throw new CannotProceed();
		}
		final List<Chicken> chickens = new ArrayList<>();
		chickenDao.findAll(pageable).forEach(c -> {
			if (c instanceof Chicken) {
				chickens.add( (Chicken) c );
			}
		});
		return chickens;
	}

	@Override
	public Chicken findById(Integer id) {
		return (Chicken) chickenDao.findOne(id);
	}

	@Override
	public List<Chicken> findByTypeAndFrecuency(String type, String frecuency) {
		final List<Chicken> chickens = new ArrayList<>();
		chickenDao.findOneByTypeAndFrecuency(type, frecuency).forEach(c -> chickens.add(c) );
		return chickens;
	}

}
