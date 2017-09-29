package com.pal.farm.mapper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public abstract class MapperServiceAbstractImpl<M, DTO> implements MapperService<M, DTO> {

	@Autowired
	protected DozerBeanMapper mapper; //lo pueden ver los hijos

	protected abstract Class<? extends M> getModelClazz();  //obliga hijos implementar esta func
	protected abstract Class<? extends DTO> getDTOClazz();  //obliga hijos implementar esta func
 	
	@Override 
	public M toModel(DTO dto, Class<? extends M> mClass) {
		return mapper.map(dto, mClass); 
	}
	
	@Override 
	public DTO toDTO(M m, Class<? extends DTO> dtoClass) {
		return mapper.map(m, dtoClass);
	}

}
