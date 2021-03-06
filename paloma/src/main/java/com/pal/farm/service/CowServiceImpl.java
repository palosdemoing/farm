package com.pal.farm.service;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.CowDAO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;
import com.pal.farm.model.Cow;


@Service
public class CowServiceImpl implements CowService {
	
	@Autowired
	private CowDAO cowDao;

	@Override
	public Cow create(Cow c) throws NotFound, AssociationNotPermittedException {
		return cowDao.save(c);
	}

	@Override
	public void delete(Cow c) throws InvalidRequestException {
//		cowDao.delete(c); 
		throw new InvalidRequestException("No se permite eliminar animales");
	}

	@Override
	public void update(Cow c) throws NotFound, AssociationNotPermittedException {
		final Cow current = findById(c.getIdAnimal());
		if (current == null || !(current instanceof Cow)) {
			throw new NotFound();
		}
		if (c.getFrecuency() != null) {
			current.setFrecuency(c.getFrecuency());
		}
		if (c.getProductions() != null && !c.getProductions().isEmpty()) {
			current.setProductions(c.getProductions());
		}
		cowDao.save(current);
	}

	@Override
	public List<Cow> getAll(Pageable pageable) throws CannotProceed {
		if (pageable.getPageSize() > 10) {
			throw new CannotProceed();
		}
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
