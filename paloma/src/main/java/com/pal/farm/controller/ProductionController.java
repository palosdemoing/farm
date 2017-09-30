package com.pal.farm.controller;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;


public interface ProductionController { // extends CRUD<ProductionDTO, Integer>{

	ProductionDTO create(ProductionDTO t) throws NotFound, AssociationNotPermittedException;

	void delete(ProductionDTO t, Integer id) throws InvalidRequestException;

	void update(ProductionDTO t, Integer id) throws NotFound, AssociationNotPermittedException;

	List<ProductionDTO> getAll(Integer page, Integer size) throws CannotProceed;

	ProductionDTO findById(Integer id) throws NotFound;

}