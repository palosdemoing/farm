package com.pal.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ChickenDAO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;
import com.pal.farm.model.Chicken;
import com.pal.farm.model.Production;

@Service
public class ChickenServiceImpl implements ChickenService {

	@Autowired
	private AnimalService animalService;

	@Autowired
	private ChickenDAO chickenDao;

	@Override
	public Chicken create(Chicken c) throws NotFound, AssociationNotPermittedException {
		List<Production> productions = c.getProductions();
		if ( productions != null ) {
			chickenDao.save(c);
			animalService.setProductions(c, productions);
		}
		return chickenDao.save(c);
	}

	@Override
	public void delete(Chicken c) throws InvalidRequestException {
		// chickenDao.delete(c);
		throw new InvalidRequestException();
	}

	@Override
	public void update(Chicken c) throws NotFound, AssociationNotPermittedException {
		final Chicken current = findById(c.getIdAnimal());
		if (current == null || !(current instanceof Chicken)) {
			throw new NotFound();
		}
		if (c.getFrecuency() != null) {
			current.setFrecuency(c.getFrecuency());
		}
		List<Production> productions = c.getProductions();
		if (productions != null) {
			animalService.setProductions(current, productions);
		}
		chickenDao.save(current);
	}

	@Override
	public List<Chicken> getAll(Pageable pageable) throws CannotProceed {
		if (pageable.getPageSize() > 10) {
			throw new CannotProceed();
		}
		final List<Chicken> chickens = new ArrayList<>();
		chickenDao.findAll(pageable).forEach(c -> {
			if (c instanceof Chicken) {
				chickens.add((Chicken) c);
			}
		});
		return chickens;
	}

	@Override
	public Chicken findById(Integer id) {
		return (Chicken) chickenDao.findOne(id);
	}

}
