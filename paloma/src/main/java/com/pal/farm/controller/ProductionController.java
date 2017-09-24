package com.pal.farm.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pal.farm.model.Production;
import com.pal.farm.service.ProductionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/production")
public class ProductionController implements CRUD<Production, Integer> {

	@Autowired
	private ProductionService productionService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public Production create(@RequestBody Production t) throws NotFound {
		log.info("Intentando crear un Production");
		return productionService.create(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody Production t) throws CannotProceed {
		log.info("Vamos a borrar Production");
		productionService.delete(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Production update(@RequestBody Production t, @PathParam("id") Integer id) throws CannotProceed, NotFound {
		log.info("Vamos a actualizar Production");
		return productionService.update(t, id);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET) 
	public List<Production> getAll(Pageable pageable) throws NotFound{
		log.info("Intento paginación ");
		return productionService.getAll(pageable);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Production findById(@PathVariable("id") Integer id) throws NotFound {
		log.info("Vamos a recuperar un Production con id " + id);
		return productionService.findById(id);
	}

//	findOneByProductionDateAndAnimal
	
}
