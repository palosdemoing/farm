package com.pal.farm.mapper;


import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.model.Chicken;


public interface ChickenMapperService { // extends MapperService<Chicken, ChickenDTO> {

	ChickenDTO toDTO(Chicken c);

	Chicken toModel(ChickenDTO dto);

}