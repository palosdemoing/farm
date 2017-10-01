package com.pal.farm.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.dao.UserDAO;
import com.pal.farm.dto.UserDTO;
import com.pal.farm.model.Animal;
import com.pal.farm.model.User;


@Component
public class UserMapperServiceImpl implements UserMapperService {
	
	@Autowired 
	private UserDAO userDao;
	
	@Autowired 
	@Qualifier("AnimalDAO")
	private AnimalDAO animalDao;
	
	@Override
	public UserDTO toDTO(User u) {
		final List<Integer> animals = new ArrayList<>();
		u.getAnimals().forEach(a -> animals.add(a.getIdAnimal()));
		return new UserDTO(u.getUsername(), animals); 
	}

	@Override
	public User toModel(UserDTO dto, String username) {
		final List<Animal> animals = new ArrayList<>();
		if (dto.getAnimals() != null && !dto.getAnimals().isEmpty()) {
			dto.getAnimals().forEach(id -> {
				final Animal a = animalDao.findOne(id);
				if (a != null) {
					animals.add(a);
				}
			});
		}
		final User u = new User();
		final User current = userDao.findUserByUsername(username);
		if (current != null) {
			u.setIdUser(current.getIdUser());
		}
		u.setUsername(dto.getUsername());
		u.setAnimals(animals);
		return u;
	}

}
