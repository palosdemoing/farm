package com.pal.farm.mapper;


public interface MapperService<M, DTO, ID> {
	
	DTO toDTO(M m);

	M toModel(DTO dto, ID id);

}
