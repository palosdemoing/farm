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
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;


//@ResponseStatus(HttpStatus.UNAUTHORIZED)


import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.service.ChickenService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(value = "/chicken")
public class ChickenController implements CRUD<ChickenDTO, Integer> {

	@Autowired
	private ChickenService chickenService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ChickenDTO create(@RequestBody ChickenDTO t) throws NotFound {
		return (ChickenDTO) chickenService.create(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody ChickenDTO t) throws CannotProceed {
		chickenService.delete(t);
		// directamente el 401????
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ChickenDTO update(@RequestBody ChickenDTO t, @PathParam("id") Integer id) throws CannotProceed, NotFound {
		return (ChickenDTO) chickenService.update(t, id);
	}

	@Override
	@RequestMapping(method=RequestMethod.GET)
	public List<ChickenDTO> getAll(Pageable pageable) throws NotFound{
		log.info("Intento paginación ");
		return chickenService.getAll(pageable);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ChickenDTO findById(@PathVariable("id") Integer id) throws NotFound {
		return (ChickenDTO) chickenService.findById(id);
	}

//	@Override
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<ChickenDTO> findByTypeAndFrecuency(@RequestParam("type") String type, @RequestParam("frecuency") String frecuency) {
		return chickenService.findByTypeAndFrecuency(type, frecuency);
	}
 
}
