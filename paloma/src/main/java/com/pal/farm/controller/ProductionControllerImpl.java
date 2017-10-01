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

import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;
import com.pal.farm.mapper.ProductionMapperService;
import com.pal.farm.mapper.ProductionMapperServiceImpl;
import com.pal.farm.model.Production;
import com.pal.farm.service.ProductionService;

import lombok.extern.slf4j.*;

@Slf4j
@RestController
@RequestMapping(value = "/production")
public class ProductionControllerImpl implements ProductionController {

	@Autowired
	private ProductionService productionService;
	
	@Autowired
	private ProductionMapperService productionMapper;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ProductionDTO create(@RequestBody ProductionDTO t) throws NotFound, AssociationNotPermittedException {
		Production p = productionMapper.toModel(t, null);
		p = productionService.create(p);
		return productionMapper.toDTO(p);
	}

	
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody ProductionDTO t, @PathVariable("id") Integer id) throws NotFound, InvalidRequestException {
		final Production p = productionMapper.toModel(t, id);
		productionService.delete(p);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody ProductionDTO t, @PathVariable("id") Integer id) throws NotFound, AssociationNotPermittedException {
		Production p = productionMapper.toModel(t, id);
		productionService.update(p);
	}

	@Override
	@RequestMapping(method=RequestMethod.GET)
	public List<ProductionDTO> getAll(@RequestParam(name = "page", required = false, defaultValue="1") Integer page,
								      @RequestParam(name = "size", required = false, defaultValue="10") Integer size) throws CannotProceed {
		
		final List<ProductionDTO> productions = new ArrayList<>();
		productionService.getAll( new PageRequest(page - 1, size) ).forEach(p -> productions.add(productionMapper.toDTO(p)) );
		return productions;
		
	}
	
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProductionDTO findById(@PathVariable("id") Integer id) throws NotFound {
		
		final Production p = productionService.findById(id);
		if (p == null) {
			throw new NotFound();
		}
		return productionMapper.toDTO(p);
		
	}
	
}
