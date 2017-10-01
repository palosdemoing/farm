package com.pal.farm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ChickenDAO;
import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.model.Chicken;
import com.pal.farm.model.Production;

// crear abstrac class para los herederos de Animal

@Service
public class ChickenMapperServiceImpl implements ChickenMapperService {

	@Autowired
	private ChickenDAO chickenDao;
	
	@Autowired
	private ProductionDAO productionDao;

	@Override
	public ChickenDTO toDTO(Chicken c) {
		final ChickenDTO dto = new ChickenDTO();
		dto.setType(c.getType());
		dto.setFrecuency(c.getFrecuency());

		final List<Integer> productions = new ArrayList<Integer>();
		c.getProductions().forEach(p -> productions.add(p.getIdProduction()));

		dto.setProductions(productions);

		return dto;
	}

	@Override
	public Chicken toModel(ChickenDTO dto, Integer id) throws NotFound, AssociationNotPermittedException {
		final Chicken c = new Chicken();

		final List<Production> productions = new ArrayList<Production>();
		if (dto.getProductions() != null && !dto.getProductions().isEmpty()) {
			for (Integer i : dto.getProductions()) {
				final Production p = productionDao.findOne(i);
				if (p == null) {
					throw new NotFound();
				} else if (p.getAnimal() != null) {
					throw new AssociationNotPermittedException("Alguna producción ya ha sido asignada");
				}
				productions.add(p);
			}
		}
		if (id != null) {
			final Chicken current = (Chicken) chickenDao.findOne(id);
			if (current != null) {
				if (dto.getType() != null) {
					current.setType(dto.getType());
				}
				if (dto.getFrecuency() != null) {
					current.setFrecuency(dto.getFrecuency());
				}
				if (!productions.isEmpty()) {
					current.getProductions().removeAll(current.getProductions());
					current.setProductions(productions);
				}
				return current;
			}	
		}
		c.setType(dto.getType());
		c.setFrecuency(dto.getFrecuency());
		c.setProductions(productions);
		return c;
	}
}
