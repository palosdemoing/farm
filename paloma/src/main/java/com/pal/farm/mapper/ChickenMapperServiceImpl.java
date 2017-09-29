package com.pal.farm.mapper;


import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.model.Chicken;
import com.pal.farm.model.Production;


@Service
public class ChickenMapperServiceImpl implements ChickenMapperService {

	@Autowired 
	private DozerBeanMapper mapper;

	@Autowired 
	private ProductionDAO productionDao;
	
	@Override
	public ChickenDTO toDTO(Chicken c) {
		final ChickenDTO dto;
		dto = mapper.map(c, ChickenDTO.class);
		
		final List<Integer> productions = new ArrayList<Integer>();
		c.getProductions().forEach(p -> productions.add(p.getIdProduction()));
		
		dto.setProductions(productions);
		
		return dto; 
	}

	@Override
	public Chicken toModel(ChickenDTO dto) {
		final Chicken c;
		c = mapper.map(dto, Chicken.class);
		
		final List<Production> productions = new ArrayList<Production>();
		dto.getProductions().forEach(id -> productions.add(productionDao.findOne(id)));
		
		c.setProductions(productions);
		return c;
	}
}
