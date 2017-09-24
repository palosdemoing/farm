package com.pal.farm.service;


import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.controller.CRUD;
import com.pal.farm.dto.UserDTO;
import com.pal.farm.model.User;


public interface UserService extends CRUD<UserDTO, Integer> {

	UserDTO findByUsername(String name) throws NotFound;

	List<User> earnsByUser(Integer id);

}
