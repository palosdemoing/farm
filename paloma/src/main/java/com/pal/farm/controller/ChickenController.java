package com.pal.farm.controller;

import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.ChickenDTO;

public interface ChickenController {

	ChickenDTO create(ChickenDTO t);

	void delete(ChickenDTO t, Integer id) throws CannotProceed;

	void update(ChickenDTO t, Integer id) throws NotFound;

	List<ChickenDTO> getAll(Integer page, Integer size) throws CannotProceed;

	ChickenDTO findById(Integer id) throws NotFound;

	List<ChickenDTO> findByTypeAndFrecuency(String type, String frecuency);

}