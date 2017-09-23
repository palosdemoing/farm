package com.pal.farm.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pal.farm.model.Chicken;

@Transactional
@Repository
public interface ChickenDAO extends AnimalDAO {

	public List<Chicken> findOneByTypeAndFrecuency(String type, String frecuency);

}
