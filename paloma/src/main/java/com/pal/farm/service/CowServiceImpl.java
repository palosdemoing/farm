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
import com.pal.farm.model.Production;

import lombok.extern.slf4j.*;

@Slf4j
@Service
public class CowServiceImpl implements CowService {

	@Autowired
	private ProductionService productionService;
	
	@Autowired
	private CowDAO cowDao;

	@Override
	public Cow create(Cow c) throws NotFound, AssociationNotPermittedException {
		List<Production> productions = c.getProductions();
		
		log.info("create sin prods " + c);
		if (!productions.isEmpty()) {
//			log.info("create prods " + productions);
			if (productionService.checkProductions(productions) > 0 ){
				throw new AssociationNotPermittedException("Alguna producción ya ha sido asignada");
			}
			cowDao.save(c);
//			productions.forEach(p -> {
//				p.setAnimal(c);
//			});	
//			log.info("create con prods " + c);
		}
		else {
			cowDao.save(c);
		}
		return c;

		
	}

	@Override
	public void delete(Cow c) throws InvalidRequestException {
//		cowDao.delete(c); 
		throw new InvalidRequestException();
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
		List<Production> productions = c.getProductions();
		if (productions != null && !productions.isEmpty()) {
//			animalService.setProductions(current, productions);
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
