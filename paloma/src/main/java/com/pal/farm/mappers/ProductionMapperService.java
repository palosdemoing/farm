package com.pal.farm.mappers;


import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.model.Production;


public interface ProductionMapperService {

	ProductionDTO map(Production p);

	Production map(ProductionDTO dto);

}
