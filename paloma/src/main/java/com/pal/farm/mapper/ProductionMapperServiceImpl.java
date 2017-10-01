package com.pal.farm.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.model.Production;

import lombok.extern.slf4j.*;

@Slf4j
@Service
public class ProductionMapperServiceImpl implements ProductionMapperService {

	@Autowired 
	public ProductionDAO productionDao;

	@Autowired 
	@Qualifier("AnimalDAO")
	public AnimalDAO animalDao;
	
	
	@Override
	public ProductionDTO toDTO(Production p) {
		final ProductionDTO dto = new ProductionDTO();
		dto.setProductionDate(p.getProductionDate());
		dto.setState(p.getState());
		dto.setOfferPrice(p.getOfferPrice());
		dto.setCostPrice(p.getCostPrice());
		return dto; 
	}

	@Override
	public Production toModel(ProductionDTO dto, Integer id) {
		final Production p = new Production();
		
		if (id != null) {
			Production current = productionDao.findOne(id);
			if ( current != null ) {
				p.setAnimal(current.getAnimal());
			}
		}
		
		p.setIdProduction(id);
		p.setProductionDate(dto.getProductionDate());
		p.setState(dto.getState());
		p.setOfferPrice(dto.getOfferPrice());
		p.setCostPrice(dto.getCostPrice());
		return p;
	}

}
