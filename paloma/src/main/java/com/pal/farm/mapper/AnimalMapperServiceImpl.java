package com.pal.farm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dto.AnimalDTO;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Production;

@Service
public class AnimalMapperServiceImpl implements AnimalMapperService {

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private ProductionDAO productionDao;

	@Override
	public AnimalDTO toDTO(Animal a) {
		final AnimalDTO dto = mapper.map(a, AnimalDTO.class);

		final List<Integer> productions = new ArrayList<Integer>();
		a.getProductions().forEach(p -> productions.add(p.getIdProduction()));

		dto.setProductions(productions);

		return dto;
	}

	@Override
	public Animal toModel(AnimalDTO dto) {
		final Animal a = mapper.map(dto, Animal.class);

		final List<Production> productions = new ArrayList<Production>();
		final List<Integer> ids = dto.getProductions();
		if (ids != null && !ids.isEmpty()) {
			ids.forEach(id -> {
				final Production p = productionDao.findOne(id);
				productions.add(p);
			});
		}

		a.setProductions(productions);
		return a;
	}
}
