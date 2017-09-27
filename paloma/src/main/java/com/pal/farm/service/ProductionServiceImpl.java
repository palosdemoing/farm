package com.pal.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.model.Production;


@Service
public class ProductionServiceImpl implements ProductionService {
	
	@Autowired
	private ProductionDAO productionDao;

	@Override
	public Production create(Production t) {
		return productionDao.save(t);
	}

	@Override
	public void delete(Production t) throws CannotProceed {
		productionDao.delete(t);
	}

	@Override
	public void update(Production t) throws NotFound {
		final Production p = findById(t.getIdProduction());
		if ( p == null ) {
			throw new NotFound();
		}
		// rescatar datos del objeto para no resetear los atributos
		productionDao.save(p);
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

}