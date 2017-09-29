package com.pal.farm.controller;


import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.dto.UserDTO;


public interface UserController extends CRUDController <UserDTO, Integer>{
	
	UserDTO findByUsername(String name) throws NotFound;

}