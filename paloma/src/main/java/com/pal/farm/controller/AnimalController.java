package com.pal.farm.controller;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pal.farm.model.Animal;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(value = "/animal")
public class AnimalController {

	
	
	// topNAnimals
}
