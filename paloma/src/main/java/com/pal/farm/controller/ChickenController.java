package com.pal.farm.controller;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.ChickenDTO;


public interface ChickenController extends CRUDController<ChickenDTO, Integer>{

	List<ChickenDTO> findByTypeAndFrecuency(String type, String frecuency) throws NotFound;

}