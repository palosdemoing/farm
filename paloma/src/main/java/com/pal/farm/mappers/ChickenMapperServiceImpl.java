package com.pal.farm.mappers;


import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.model.Chicken;


@Service
public class ChickenMapperServiceImpl implements ChickenMapperService {

	@Autowired 
	public DozerBeanMapper mapper;
	
	@Override
	public ChickenDTO toDTO(Chicken c) {
		return mapper.map(c, ChickenDTO.class);
	}

	@Override
	public Chicken toModel(ChickenDTO dto) {
		return mapper.map(dto, Chicken.class);
	}
}
