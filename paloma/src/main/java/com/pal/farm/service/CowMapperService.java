package com.pal.farm.service;

import com.pal.farm.dto.CowDTO;
import com.pal.farm.model.Cow;

public interface CowMapperService {

	CowDTO map(Cow c);

	Cow map(CowDTO dto);

}
