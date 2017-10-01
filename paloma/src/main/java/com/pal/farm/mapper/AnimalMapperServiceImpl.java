package com.pal.farm.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ProductionDAO;
import com.pal.farm.dto.AnimalDTO;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Chicken;
import com.pal.farm.model.Cow;

@Service
public class AnimalMapperServiceImpl implements AnimalMapperService {

	@Autowired
	private ChickenMapperService chickenMapper;

	@Autowired
	private CowMapperService cowMapper;


	@Override
	public AnimalDTO toDTO(Animal a) {
		if (a.getClass() == Chicken.class) {
			return chickenMapper.toDTO((Chicken) a);
		}
		if (a.getClass() == Cow.class) {
			return cowMapper.toDTO((Cow) a);
		}
		return new AnimalDTO();
	}

	@Override
	public Animal toModel(AnimalDTO dto, Integer id) {
		return null;
	}
}
