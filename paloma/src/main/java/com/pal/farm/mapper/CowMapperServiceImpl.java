package com.pal.farm.mapper;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dto.CowDTO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.model.Cow;
import com.pal.farm.model.Production;


//crear abstrac class para los herederos de Animal

@Service
public class CowMapperServiceImpl implements CowMapperService {

	@Autowired
	private ProductionDAO productionDao;

	@Override
	public CowDTO toDTO(Cow c) {
		final CowDTO dto = new CowDTO();
		dto.setType(c.getType());
		dto.setFrecuency(c.getFrecuency());

		final List<Integer> productions = new ArrayList<Integer>();
		c.getProductions().forEach(p -> productions.add(p.getIdProduction()));
		dto.setProductions(productions);

		return dto;
	}

	@Override
	public Cow toModel(CowDTO dto, Integer id) throws NotFound, AssociationNotPermittedException {
		final Cow c = new Cow();
		c.setIdAnimal(id);
		c.setType(dto.getType());
		c.setFrecuency(dto.getFrecuency());

		final List<Production> productions = new ArrayList<Production>();
		if (dto.getProductions() != null && !dto.getProductions().isEmpty()) {
			for(Integer i : dto.getProductions()) {
				final Production p = productionDao.findOne(i);
				if (p == null) {
					throw new NotFound();
				} 
				else if (p.getAnimal() != null) {
					throw new AssociationNotPermittedException("Alguna producción ya ha sido asignada");
				}
				productions.add(p);
			}
		}
		c.setProductions(productions);
		
		return c;
	}
}