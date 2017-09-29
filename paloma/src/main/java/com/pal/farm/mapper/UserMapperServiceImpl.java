package com.pal.farm.mapper;


import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.dto.UserDTO;
import com.pal.farm.model.Animal;
import com.pal.farm.model.User;


@Component
public class UserMapperServiceImpl implements UserMapperService {  // extends MapperService<User, UserDTO>

	@Autowired 
	private DozerBeanMapper mapper;
	
	@Autowired 
	@Qualifier("AnimalDAO")
	private AnimalDAO animalDao;
	
	@Override
	public UserDTO toDTO(User u) {
		final UserDTO dto;
		dto = mapper.map(u, UserDTO.class);
		
		final List<Integer> animals = new ArrayList<Integer>();
		u.getAnimals().forEach(a -> animals.add(a.getIdAnimal()));
		
		dto.setAnimals(animals);
		
		return dto; 
	}

	@Override
	public User toModel(UserDTO dto) {
		final User c;
		c = mapper.map(dto, User.class);
		
		final List<Animal> animals = new ArrayList<Animal>();
		dto.getAnimals().forEach(id -> animals.add(animalDao.findOne(id)));
		
		c.setAnimals(animals);
		return c;
	}

}