package com.pal.farm.mappers;


import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Production;
import com.pal.farm.model.Production;


@Service
public class ProductionMapperServiceImpl implements ProductionMapperService {

	@Autowired 
	public DozerBeanMapper mapper;

	@Autowired 
	public ProductionDAO productionDao;

	@Autowired 
	public AnimalDAO animalDao;
	
	@Override
	public ProductionDTO toDTO(Production p) {
		final ProductionDTO dto;
		dto = mapper.map(p, ProductionDTO.class);
		dto.setAnimal(p.getAnimal().getIdAnimal());
		return dto; 
	}

	@Override
	public Production toModel(ProductionDTO dto) {
		final Production p;
		final Animal a = animalDao.findOne(dto.getAnimal());
		p = mapper.map(dto, Production.class);
		p.setAnimal(a);
		return p;
	}

}
