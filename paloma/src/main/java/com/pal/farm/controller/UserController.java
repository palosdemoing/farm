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

import com.pal.farm.dto.UserDTO;
import com.pal.farm.model.User;
import com.pal.farm.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController implements CRUD<UserDTO, Integer> {

	@Autowired
	private UserService userService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserDTO t) throws NotFound {
		return userService.create(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody UserDTO t, @PathParam("id") Integer id) throws CannotProceed {
		userService.delete(t, id);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public UserDTO update(@RequestBody UserDTO t, @PathParam("id") Integer id) throws CannotProceed, NotFound {
		return userService.update(t, id);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET) 
	public List<UserDTO> getAll(Pageable pageable) throws NotFound {
		return userService.getAll(pageable);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDTO findById(@PathVariable("id") Integer id) throws NotFound {
		return userService.findById(id);
	}

	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public UserDTO findByUsername(@PathVariable("name") String name) throws NotFound {
		log.info("Vamos a recuperar un usuario con id " + name);
		return userService.findByUsername(name);
	}
	
	@RequestMapping(value = "/earn/{name}", method = RequestMethod.GET)
	public List<User> earnsByUser(@PathVariable("name") Integer name) throws NotFound {
		log.info("Vamos a recuperar un usuario con id " + name);
		return userService.earnsByUser(name);
	}

}
