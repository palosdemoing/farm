package com.pal.farm.service;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;
import com.pal.farm.model.Animal;


@Service
public class AnimalServiceImpl implements AnimalService {
	
	@Autowired
	@Qualifier("AnimalDAO")
	private AnimalDAO animalDao;


	@Override
	public List<Animal> findByUser(Integer user) {
		return animalDao.findByUser(user);		
	}
	

	@Override
	public List<Integer> getAllIds() {
		List<Integer> ids = new ArrayList<>();
		Iterable<Animal> list = animalDao.findAll();
		list.forEach(a -> ids.add(a.getIdAnimal()));
		return ids;
	}
	

	@Override
	public List<Integer> getAllIdsByUserId(Integer user) {
		List<Integer> ids = new ArrayList<>();
		Iterable<Animal> list = animalDao.findByUser(user);
		list.forEach(a -> ids.add(a.getIdAnimal()));
		return ids;
	}

	
	@Override
	public void update(Animal a) {
		animalDao.save(a);
	}
	
	
	@Override
	public Animal findById(Integer id) {
		return animalDao.findOne(id);
	}


	@Override
	public Animal create(Animal t) throws NotFound, AssociationNotPermittedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Animal t) throws InvalidRequestException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Animal> getAll(Pageable pageable) throws CannotProceed {
		return null;
	}
	
}
