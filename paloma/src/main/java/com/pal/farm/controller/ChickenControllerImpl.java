package com.pal.farm.controller;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.mapper.ChickenMapperService;
import com.pal.farm.model.Chicken;
import com.pal.farm.service.ChickenService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/chicken")
public class ChickenControllerImpl implements ChickenController { 

	@Autowired
	private ChickenService chickenService;
	
	@Autowired
	private ChickenMapperService chickenMapper;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ChickenDTO create(@RequestBody ChickenDTO t) {
		Chicken c = chickenMapper.toModel(t);
		log.info("creando: " + c);
		c = chickenService.create(c);
		return chickenMapper.toDTO(c);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody ChickenDTO t, @PathVariable("id") Integer id) throws CannotProceed {
		final Chicken c = chickenMapper.toModel(t);
		log.info("borrando: " + c);
		c.setIdAnimal(id);
		chickenService.delete(c);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody ChickenDTO t, @PathVariable("id") Integer id) throws NotFound {
		final Chicken c = chickenMapper.toModel(t);
		c.setIdAnimal(id);
		log.info("actualizando: " + c);
		chickenService.update(c);
	}

	@Override
	@RequestMapping(method=RequestMethod.GET)
	public List<ChickenDTO> getAll(@RequestParam(name = "page", required = false, defaultValue="0") Integer page,
								   @RequestParam(name = "size", required = false, defaultValue="10") Integer size) throws CannotProceed {
		
		final List<ChickenDTO> chickens = new ArrayList<>();
		chickenService.getAll( new PageRequest(page + 1, size) ).forEach(c -> chickens.add(chickenMapper.toDTO(c)) );
		log.info("listando: " + chickens);
		return chickens;
		
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ChickenDTO findById(@PathVariable("id") Integer id) throws NotFound {
		
		final Chicken c = chickenService.findById(id);
		log.info("buscando: " + c);
		if (c == null) {
			throw new NotFound();
		}
		return chickenMapper.toDTO(c);
		
	}
	
}
