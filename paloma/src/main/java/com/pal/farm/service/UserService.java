package com.pal.farm.service;


import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.model.User;


public interface UserService extends CRUDService<User, Integer> {

	User findByUsername(String name) throws NotFound;

}
