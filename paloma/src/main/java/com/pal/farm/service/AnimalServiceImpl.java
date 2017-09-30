package com.pal.farm.service;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Production;


@Service
public class AnimalServiceImpl implements AnimalService {
	
	@Autowired
	@Qualifier("AnimalDAO")
	private AnimalDAO animalDao;
	
	@Autowired
	private ProductionService productionService;

	@Override
	public List<Animal> findByUser(String username) {
		return animalDao.findByUser(username);		
	}
	

	private Integer checkProductions(List<Production> productions) {
		Integer count = productions.size();

		for (Production p : productions) {
			if (p.getAnimal() == null) {
				count--;
			}
		}
		return count;
	}


	@Override
	public void setProductions(Animal a, List<Production> productions) throws NotFound, AssociationNotPermittedException {
		if (checkProductions(productions) > 0 ){
			throw new AssociationNotPermittedException("Alguna producción ya ha sido asignada");
		}
		productions.forEach(p -> {
			p.setAnimal(a);
			try {
				productionService.update(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			a.getProductions().add(p);
		});
		
	}


	@Override
	public void update(Animal a) {
		animalDao.save(a);
	}
	
	@Override
	public Animal findById(Integer id) {
		return animalDao.findOne(id);
	}
	
}
