package com.pal.farm.service;

import java.util.Date;
import java.util.List;

import com.pal.farm.dto.AnimalProfitsDTO;
import com.pal.farm.dto.UserProfitsDTO;

public interface StatsService {

	List<AnimalProfitsDTO> profitsByAnimal(); // Integer n);

//	List<UserProfitsDTO> profitsByUser(String name, Date startDate, Date endsDate);

}
