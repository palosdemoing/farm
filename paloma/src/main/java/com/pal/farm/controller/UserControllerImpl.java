package com.pal.farm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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

import com.pal.farm.dto.UserDTO;
import com.pal.farm.mapper.UserMapperService;
import com.pal.farm.model.User;
import com.pal.farm.service.UserService;


@RestController
@RequestMapping(value = "/user")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapperService userMapper;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserDTO t) {
		User u = userMapper.toModel(t);
		u = userService.create(u);
		return userMapper.toDTO(u);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody UserDTO t, @PathParam("id") Integer id) throws CannotProceed {
		final User u = userMapper.toModel(t);
		u.setIdUser(id);
		userService.delete(u);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody UserDTO t, @PathParam("id") Integer id) throws NotFound {
		User u = userMapper.toModel(t);
		u.setIdUser(id);
		userService.update(u);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET) 
	public List<UserDTO> getAll(@RequestParam(name = "page", required = false, defaultValue="0") Integer page,
			      @RequestParam(name = "size", required = false, defaultValue="10") Integer size) throws CannotProceed {

		final List<UserDTO> users = new ArrayList<>();
		userService.getAll( new PageRequest(page + 1, size) ).forEach(u -> users.add(userMapper.toDTO(u)) );
		return users;
		
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDTO findById(@PathVariable("id") Integer id) throws NotFound {
		
		final User u = userService.findById(id);
		if (u == null) {
			throw new NotFound();
		}
		return userMapper.toDTO(u);
	}

	
	@Override
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public UserDTO findByUsername(@PathVariable("name") String name) throws NotFound {
		
		final User u = userService.findByUsername(name);
		if (u == null) {
			throw new NotFound();
		}
		return userMapper.toDTO(u);
	}


}
