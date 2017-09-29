package com.pal.farm.service;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.CowDAO;
import com.pal.farm.model.Cow;


@Service
public class CowServiceImpl implements CowService {
	
	@Autowired
	private CowDAO cowDao;

	@Override
	public Cow create(Cow c) {
		return cowDao.save(c);
	}

	@Override
	public void delete(Cow c) throws CannotProceed {
//		cowDao.delete(c);  // error 401
		throw new CannotProceed();
	}

	@Override
	public void update(Cow c) throws NotFound {
		if ( cowDao.findOne(c.getIdAnimal()) instanceof Cow ) {
			throw new NotFound();
		}

		// get user, recorrer valores para no eliminar los que recibidos como null
		cowDao.save(c);
	}

	@Override
	public List<Cow> getAll(Pageable pageable) {
		final List<Cow> cows = new ArrayList<>();
		cowDao.findAll(pageable).forEach(c -> {
			if (c instanceof Cow) {
				cows.add((Cow) c);
			}
		});
		return cows;
	}

	@Override
	public Cow findById(Integer id) {
		return (Cow) cowDao.findOne(id);
	}
	
}
