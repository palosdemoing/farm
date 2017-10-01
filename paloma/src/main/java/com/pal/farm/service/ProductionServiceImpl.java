package com.pal.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;
import com.pal.farm.model.Production;

import lombok.extern.slf4j.*;

@Slf4j
@Service
public class ProductionServiceImpl implements ProductionService {
	
	@Autowired
	private ProductionDAO productionDao;

	
	@Override
	public Production create(Production p) {
		return productionDao.save(p);
	}

	
	@Override
	public void delete(Production p) throws InvalidRequestException {
		productionDao.delete(p);
	}

	
	@Override
	public void update(Production p) throws NotFound, AssociationNotPermittedException {
		final Production current = findById(p.getIdProduction());
	
		if ( current == null ) {
			throw new NotFound();
		}
		
		if ( p.getProductionDate() != null ) {
			current.setProductionDate(p.getProductionDate());
		}
		
		if ( p.getState() != null ) {
			current.setState(p.getState());
		}
		
		if ( p.getCostPrice() != null ) {
			current.setCostPrice(p.getCostPrice());
		}

		if ( p.getOfferPrice() != null ) {
			current.setOfferPrice(p.getOfferPrice());
		}
		
//		if ( p.getAnimal() != null ) {
//			current.setAnimal(p.getAnimal());
//		}

		productionDao.save(current);
	}
	

	
	@Override
	public List<Production> getAll(Pageable pageable) throws CannotProceed {
		if (pageable.getPageSize() > 10) {
			throw new CannotProceed();
		}
		final List<Production> productions = new ArrayList<>();
		productionDao.findAll(pageable).forEach(p -> productions.add(p));
		return productions;
	}

	@Override
	public Production findById(Integer id) {
		return productionDao.findOne(id);
	}

	@Override
	public List<Production> productionsByAnimal(Integer idAnimal) {
		return productionDao.findAllByAnimal(idAnimal);
	}
	
	@Override
	public Integer checkProductions(List<Production> productions) {
		Integer count = productions.size();
		log.info("en check prods " + count);
		for (Production p : productions) {
//			if (p.getAnimal() == null) {
//				count--;
//			}
		}
		return count;
	}

}