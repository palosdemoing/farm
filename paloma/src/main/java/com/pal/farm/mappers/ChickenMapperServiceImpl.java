package com.pal.farm.mappers;


import org.springframework.stereotype.Service;

import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.model.Chicken;


@Service
public class ChickenMapperServiceImpl implements ChickenMapperService {

	@Override
	public ChickenDTO map(Chicken c) {
		final ChickenDTO dto = new ChickenDTO(c.getType(), c.getFrecuency());
		return dto;
	}

	@Override
	public Chicken map(ChickenDTO dto) {
		final Chicken c = new Chicken(dto.getType(), dto.getFrecuency());
		return c;
	}

}
