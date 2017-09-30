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
		final UserDTO dto = mapper.map(u, UserDTO.class);
		
		final List<String> animals = new ArrayList<String>();
		u.getAnimals().forEach(a -> animals.add(a.getIdAnimal().toString()));
		
		dto.setAnimals(animals);
//		Animal(idAnimal=1, type=chicken, frecuency=diaria, user=null, productions=[]) requiere setear el user cuando linked
		
		return dto; 
	}

	@Override
	public User toModel(UserDTO dto) {
		final User c = mapper.map(dto, User.class);
		
		final List<Animal> animals = new ArrayList<Animal>();
		final List<String> ids = dto.getAnimals();
		if (ids != null && !ids.isEmpty()) {
			ids.forEach(id -> {
				final Integer mapped = Integer.parseInt(id); 
				final Animal a = animalDao.findOne(mapped);
				animals.add(a);
			});
		}
		
		c.setAnimals(animals);
		return c;
	}

}
