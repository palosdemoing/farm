package com.pal.farm.service;

import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.model.Chicken;

public interface ChickenMapperService {

	ChickenDTO map(Chicken c);

	Chicken map(ChickenDTO dto);

}
