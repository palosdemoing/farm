package com.pal.farm.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface ChickenDAO extends AnimalDAO {
	
}
