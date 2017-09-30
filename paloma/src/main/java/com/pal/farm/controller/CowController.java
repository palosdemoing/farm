package com.pal.farm.controller;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.CowDTO;
import com.pal.farm.dto.ProductionDTO;


public interface CowController extends CRUDController<CowDTO, Integer>{

	List<ProductionDTO> findAnimalProductionById(Integer id) throws NotFound;

}