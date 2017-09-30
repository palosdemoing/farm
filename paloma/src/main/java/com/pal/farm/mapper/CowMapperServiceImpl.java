package com.pal.farm.mapper;


import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dto.CowDTO;
import com.pal.farm.model.Cow;
import com.pal.farm.model.Production;


@Service
public class CowMapperServiceImpl implements CowMapperService {

	@Autowired 
	private DozerBeanMapper mapper;

	@Autowired 
	private ProductionDAO productionDao;
	
	@Override
	public CowDTO toDTO(Cow c) {
		final CowDTO dto = mapper.map(c, CowDTO.class);
		
		final List<Integer> productions = new ArrayList<Integer>();
		c.getProductions().forEach(p -> productions.add(p.getIdProduction()));
		
		dto.setProductions(productions);
		
		return dto; 
	}

	@Override
	public Cow toModel(CowDTO dto) {
		final Cow c = mapper.map(dto, Cow.class);
		
		final List<Production> productions = new ArrayList<Production>();	
		final List<Integer> ids = dto.getProductions();
		if (ids != null && !ids.isEmpty()) {
			ids.forEach(id -> {
				final Production p = productionDao.findOne(id);
				productions.add(p);
			});
		}
		
		c.setProductions(productions);
		return c;
	}
}