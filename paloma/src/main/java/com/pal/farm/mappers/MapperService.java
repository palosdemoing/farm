package com.pal.farm.mappers;


public interface MapperService<M, DTO> {
	
	DTO toDTO(M m, Class<? extends DTO> dto);

	M toModel(DTO dto, Class<? extends M> m);

}
