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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pal.farm.dto.CowDTO;
import com.pal.farm.service.CowService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/cow")
public class CowController implements CRUD<CowDTO, Integer> {

	@Autowired
	private CowService cowService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public CowDTO create(@RequestBody CowDTO t) throws NotFound {
		return cowService.create(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody CowDTO t) throws CannotProceed {
		cowService.delete(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public CowDTO update(@RequestBody CowDTO t, @PathParam("id") Integer id) throws CannotProceed, NotFound {
		return cowService.update(t, id);
	}

	@Override
	@RequestMapping(method=RequestMethod.GET)
	public List<CowDTO> getAll(Pageable pageable) throws NotFound{
		return cowService.getAll(pageable);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CowDTO findById(@PathVariable("id") Integer id) throws NotFound {
		return cowService.findById(id);
	}
 
//	@Override
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<CowDTO> findByTypeAndFrecuency(@RequestParam("type") String type, @RequestParam("frecuency") String frecuency) {
		return cowService.findByTypeAndFrecuency(type, frecuency);
	}
	
}
