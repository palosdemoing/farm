package com.pal.farm.mapper;

import com.pal.farm.dto.CowDTO;
import com.pal.farm.model.Cow;

public interface CowMapperService { // extends MapperService<Chicken, ChickenDTO> {

	CowDTO toDTO(Cow c);

	Cow toModel(CowDTO dto);

}
