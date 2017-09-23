package com.pal.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pal.farm.model.Cow;
import com.pal.farm.service.CowService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/cow")
public class CowController implements CRUD<Cow, Integer> {

	@Autowired
	private CowService cowService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public Cow create(@RequestBody Cow t) {
		log.info("Intentando crear un objeto cow");
		return cowService.create(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody Cow t) {
		log.info("Vamos a borrar un objeto cow");
		cowService.delete(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Cow update(@RequestBody Cow t) {
		log.info("Vamos a actualizar un objeto cow");
		return cowService.update(t);
	}

	@Override
	@RequestMapping(method=RequestMethod.GET)
	public List<Cow> getAll(Pageable pageable){
		log.info("Intento paginación ");
		return cowService.getAll(pageable);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Cow findById(@PathVariable("id") Integer id) {
		log.info("Vamos a recuperar un objeto cow con id " + id);
		return cowService.findById(id);
	}
 
}
