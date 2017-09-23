package com.pal.farm.service;

import org.springframework.stereotype.Service;

import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.model.Production;


@Service
public class ProductionMapperServiceImpl implements ProductionMapperService {

	@Override
	public ProductionDTO map(Production p) {
		final ProductionDTO dto = new ProductionDTO(p.getProductionDate(), p.getState(), p.getPriceBougth(), p.getPriceSold());
		return dto;
	}

	@Override
	public Production map(ProductionDTO dto) {
		final Production p = new Production(dto.getProductionDate(), dto.getState(), dto.getPriceBought(), dto.getPriceSold());
		return p;
	}

}
