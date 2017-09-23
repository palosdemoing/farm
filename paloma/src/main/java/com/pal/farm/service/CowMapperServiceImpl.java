package com.pal.farm.service;

import org.springframework.stereotype.Service;

import com.pal.farm.dto.CowDTO;
import com.pal.farm.model.Cow;


@Service
public class CowMapperServiceImpl implements CowMapperService {
	
	@Override
	public CowDTO map(Cow c) {
		final CowDTO dto = new CowDTO(c.getType(), c.getFrecuency());
		return dto;
	}

	@Override
	public Cow map(CowDTO dto) {
		final Cow c = new Cow(dto.getType(), dto.getFrecuency());
		return c;
	}

}