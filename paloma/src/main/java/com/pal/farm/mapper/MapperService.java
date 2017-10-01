package com.pal.farm.mapper;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.exception.AssociationNotPermittedException;

public interface MapperService<M, DTO, ID> {
	
	DTO toDTO(M m);

	M toModel(DTO dto, ID id) throws NotFound, AssociationNotPermittedException;

}
