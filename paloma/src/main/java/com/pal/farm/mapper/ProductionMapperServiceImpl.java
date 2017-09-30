package com.pal.farm.mapper;


import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Production;


@Service
public class ProductionMapperServiceImpl implements ProductionMapperService {

	@Autowired 
	public DozerBeanMapper mapper;

	@Autowired 
	public ProductionDAO productionDao;

	@Autowired 
	@Qualifier("AnimalDAO")
	public AnimalDAO animalDao;
	
	
	@Override
	public ProductionDTO toDTO(Production p) {
		final ProductionDTO dto = mapper.map(p, ProductionDTO.class);
		if (p.getAnimal() != null) {
			dto.setAnimal(p.getAnimal().getIdAnimal());
		}
		return dto; 
	}

	@Override
	public Production toModel(ProductionDTO dto) {
		final Production p = mapper.map(dto, Production.class);
		Animal a = null;
		if (dto.getAnimal() != null) {
			a = animalDao.findOne(dto.getAnimal());
		}
		if (a != null) {
			p.setAnimal(a);
		}
		return p;
	}

}
