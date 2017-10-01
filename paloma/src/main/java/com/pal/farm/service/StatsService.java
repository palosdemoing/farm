package com.pal.farm.service;

import java.util.Date;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.AnimalProfitsDTO;
import com.pal.farm.dto.UserProfitsDTO;

public interface StatsService {

	UserProfitsDTO profitsByUser(String name, Date startDate, Date endsDate) throws NotFound;

	List<AnimalProfitsDTO> profitsByAnimal(Integer n);

}
