package com.pal.farm.mappers;


import com.pal.farm.dto.CowDTO;
import com.pal.farm.model.Cow;


public interface CowMapperService {

	CowDTO map(Cow c);

	Cow map(CowDTO dto);

}
