package com.pal.farm.dao;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pal.farm.model.User;


@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Integer> {
	
	public User findUserByUsername(String username) throws NotFound;

//	public List<User> findUserWherePriceXXXXXXXXXXXX(Integer id);

}
