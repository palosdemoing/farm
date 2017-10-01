package com.pal.farm.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.AnimalDAO;
import com.pal.farm.dto.AnimalProfitsDTO;
import com.pal.farm.dto.UserProfitsDTO;
import com.pal.farm.model.Animal;
import com.pal.farm.model.Production;
import com.pal.farm.model.User;

@Service
public class StatsServiceImpl implements StatsService {

	@Autowired
	private UserService userService;

	@Autowired 
	public AnimalService animalService;

	@Autowired
	private ProductionService productionService;

	@Autowired
	@Qualifier("AnimalDAO")
	private AnimalDAO animalDao;
	

	@Override
	public List<AnimalProfitsDTO> profitsByAnimal(Integer n){
		List<Integer> animalIds = animalService.getAllIds();
		Integer idx = animalIds.size();
		AnimalProfitsDTO[] resultSet = new AnimalProfitsDTO[idx];	
		
		for (Integer id : animalIds) {	
			AnimalProfitsDTO dto = new AnimalProfitsDTO();
			Animal a = animalService.findById(id);
			Double profits = 0.0;
			List<Production> productions = productionService.productionsByAnimal(id);
			
			for (Production p : productions) {
				profits += (p.getOfferPrice() - p.getCostPrice());
			}
			dto.setAnimalClass(a.getClass().toString());
			dto.setAnimalType(a.getType());
			resultSet[idx-1] = dto;
			idx--;
		}
		Arrays.sort(resultSet);
		return Arrays.asList(resultSet).subList(resultSet.length-n-1, resultSet.length-1);
	}


	@Override
	public UserProfitsDTO profitsByUser(String name, Date startDate, Date endsDate) throws NotFound {
		
		User u = userService.findByUsername(name);
		UserProfitsDTO dto = new UserProfitsDTO();
		if (u == null) {
			return dto;
		}
		
		List<Integer> animalIds = animalService.getAllIdsByUserId(u.getIdUser());
		Double profits = 0.0;
		
		for (int idx = animalIds.size(); idx > 0; idx--) {	
			List<Production> productions = productionService.productionsByAnimalAndRange(animalIds.get(idx), startDate, endsDate);
			
			for (Production p : productions) {
				profits += (p.getOfferPrice() - p.getCostPrice());
			}
			idx--;
		}
		dto.setProfits(profits);
		return dto;

	}

}
