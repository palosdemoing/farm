package com.pal.farm.mappers;


import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.model.Chicken;


public interface ChickenMapperService {

	ChickenDTO toDTO(Chicken c); // extends MapperService<Chicken, ChickenDTO> {

	Chicken toModel(ChickenDTO dto);

}
