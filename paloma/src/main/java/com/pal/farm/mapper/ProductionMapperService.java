package com.pal.farm.mappers;


import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.model.Production;


public interface ProductionMapperService { // extends MapperService<Production, ProductionDTO> {

	ProductionDTO toDTO(Production p);

	Production toModel(ProductionDTO dto);

}
