package com.pal.farm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.model.Chicken;
import com.pal.farm.model.Production;


// crear abstrac class para los herederos de Animal


@Service
public class ChickenMapperServiceImpl implements ChickenMapperService {

	@Autowired
	private ProductionDAO productionDao;

	@Override
	public ChickenDTO toDTO(Chicken c) {
		final ChickenDTO dto = new ChickenDTO();
		

		final List<Integer> productions = new ArrayList<Integer>();
		c.getProductions().forEach(p -> productions.add(p.getIdProduction()));

		dto.setProductions(productions);

		return dto;
	}

	@Override
	public Chicken toModel(ChickenDTO dto, Integer id) {
		final Chicken c = new Chicken();
		c.setIdAnimal(id);
		c.setType(dto.getType());
		c.setFrecuency(dto.getFrecuency());

		final List<Production> productions = new ArrayList<Production>();
		final List<Integer> ids = dto.getProductions();
		if (ids != null && !ids.isEmpty()) {
			ids.forEach(i -> {
				final Production p = productionDao.findOne(i);
				if (p != null) {
					productions.add(p);
				}
			});
		}
		c.setProductions(productions);
		
		return c;
	}
}
