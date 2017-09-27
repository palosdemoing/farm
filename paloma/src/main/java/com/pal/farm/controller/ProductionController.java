package com.pal.farm.controller;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.ProductionDTO;


public interface ProductionController {

	ProductionDTO create(ProductionDTO t);

	void delete(ProductionDTO t, Integer id) throws CannotProceed;

	void update(ProductionDTO t, Integer id) throws NotFound;

	List<ProductionDTO> getAll(Integer page, Integer size) throws CannotProceed;

	ProductionDTO findById(Integer id) throws NotFound;

}