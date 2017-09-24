package com.pal.farm.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pal.farm.model.Cow;


@Transactional
@Repository
public interface CowDAO extends AnimalDAO {

	public List<Cow> findOneByTypeAndFrecuency(String type, String frecuency);

}
