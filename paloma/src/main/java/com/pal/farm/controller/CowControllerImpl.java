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

import com.pal.farm.dto.CowDTO;
import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;
import com.pal.farm.mapper.CowMapperService;
import com.pal.farm.mapper.ProductionMapperService;
import com.pal.farm.model.Cow;
import com.pal.farm.service.CowService;


@RestController
@RequestMapping(value = "/cow")
public class CowControllerImpl implements CowController { 

	@Autowired
	private CowService cowService;
	
	@Autowired
	private CowMapperService cowMapper;
	
	@Autowired
	private ProductionMapperService productionMapper;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public CowDTO create(@RequestBody CowDTO t) throws NotFound, AssociationNotPermittedException {
		Cow c = cowMapper.toModel(t);
		c = cowService.create(c);
		return cowMapper.toDTO(c);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody CowDTO t, @PathVariable("id") Integer id) throws NotFound, InvalidRequestException {
		final Cow c = cowMapper.toModel(t);
		c.setIdAnimal(id);
		cowService.delete(c);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody CowDTO t, @PathVariable("id") Integer id) throws NotFound, AssociationNotPermittedException {
		final Cow c = cowMapper.toModel(t);
		c.setIdAnimal(id);
		cowService.update(c);
	}

	@Override
	@RequestMapping(method=RequestMethod.GET)
	public List<CowDTO> getAll(@RequestParam(name = "page", required = false, defaultValue="0") Integer page,
								   @RequestParam(name = "size", required = false, defaultValue="10") Integer size) throws CannotProceed {
		
		final List<CowDTO> cows = new ArrayList<>();
		cowService.getAll( new PageRequest(page + 1, size) ).forEach(c -> cows.add(cowMapper.toDTO(c)) );
		return cows;
		
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CowDTO findById(@PathVariable("id") Integer id) throws NotFound {
		
		final Cow c = cowService.findById(id);
		if (c == null) {
			throw new NotFound();
		}
		return cowMapper.toDTO(c);
		
	}

	
	@Override
	@RequestMapping(value = "/{id}/productions", method = RequestMethod.GET)
	public List<ProductionDTO> findAnimalProductionById(@PathVariable("id") Integer id) throws NotFound {
		final Cow c = cowService.findById(id);
		if (c != null && c.getProductions() != null) {
			final List<ProductionDTO> productions = new ArrayList<>();
			c.getProductions().forEach( p -> productions.add(productionMapper.toDTO(p)) );
			return productions;
		}

		throw new NotFound();
		
	}
	
}
