package com.pal.farm.mapper;

import com.pal.farm.dto.AnimalDTO;
import com.pal.farm.model.Animal;

public interface AnimalMapperService {

	AnimalDTO toDTO(Animal c);

	Animal toModel(AnimalDTO dto);
}
