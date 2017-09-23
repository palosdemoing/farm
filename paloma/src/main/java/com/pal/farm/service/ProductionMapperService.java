package com.pal.farm.service;

import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.model.Production;

public interface ProductionMapperService {

	ProductionDTO map(Production p);

	Production map(ProductionDTO dto);


}
