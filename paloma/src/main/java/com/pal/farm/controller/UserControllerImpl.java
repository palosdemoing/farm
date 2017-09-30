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

import com.pal.farm.dto.AnimalDTO;
import com.pal.farm.dto.ProductionDTO;
import com.pal.farm.dto.UserDTO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;
import com.pal.farm.mapper.AnimalMapperService;
import com.pal.farm.mapper.ProductionMapperService;
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

	@Autowired
	private AnimalMapperService animalMapper;
	@Autowired
	private ProductionMapperService productionMapper;
	
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserDTO t) throws NotFound, AssociationNotPermittedException {
		User u = userMapper.toModel(t);
		u = userService.create(u);
		return userMapper.toDTO(u);
	}

	@Override
	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	public void delete(@RequestBody UserDTO t, @PathParam("username") String username) throws NotFound, InvalidRequestException {
		final User u = userMapper.toModel(t);
		u.setIdUser(userService.findByUsername(username).getIdUser());
		if (u.getIdUser() == null) {
			throw new NotFound();
		}
		userService.delete(u);
	}

	@Override
	@RequestMapping(value = "/{username}", method = RequestMethod.PUT)
	public void update(@RequestBody UserDTO t, @PathParam("username") String username) throws NotFound, AssociationNotPermittedException {
		User u = userMapper.toModel(t);
		u.setIdUser(userService.findByUsername(username).getIdUser());
		userService.update(u);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET) 
	public List<UserDTO> getAll(@RequestParam(name = "page", required = false, defaultValue="1") Integer page,
			      				@RequestParam(name = "size", required = false, defaultValue="10") Integer size) 
			throws CannotProceed {

		final List<UserDTO> users = new ArrayList<>();
		userService.getAll( new PageRequest(page - 1, size) ).forEach(u -> users.add(userMapper.toDTO(u)) );
		return users;
		
	}

	@Override
	public UserDTO findById(Integer id) throws NotFound {
		throw new NotFound();
		
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

	
	@Override
	@RequestMapping(value = "/{name}/animals", method = RequestMethod.GET)
	public List<AnimalDTO> findAnimalsByUsername(@PathVariable("name") String name) throws NotFound {
		final User u = userService.findByUsername(name);
		if (u == null || u.getAnimals() == null) {
			throw new NotFound();
		}
		final List<AnimalDTO> animals = new ArrayList<>();
		u.getAnimals().forEach( a -> animals.add(animalMapper.toDTO(a)) );
		return animals;
	}
	
	@Override
	@RequestMapping(value = "/{name}/animals/{id}/productions", method = RequestMethod.GET)
	public List<ProductionDTO> findAnimalProductionByUsername(@PathVariable("name") String name, @PathVariable("id") Integer id) throws NotFound {
		final User u = userService.findByUsername(name);
		if (u != null && u.getAnimals() != null) {
			final List<ProductionDTO> productions = new ArrayList<>();
			u.getAnimals().forEach( a -> {
				if (a.getIdAnimal() == id && a.getProductions() != null) {
					 a.getProductions().forEach( p -> productions.add(productionMapper.toDTO(p)) );
				}
			});
			return productions;
		}

		throw new NotFound();
		
	}

}
