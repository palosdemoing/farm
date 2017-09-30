package com.pal.farm.controller;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.dto.ProductionDTO;


public interface ChickenController extends CRUDController<ChickenDTO, Integer>{

	List<ProductionDTO> findAnimalProductionById(Integer id) throws NotFound;

}