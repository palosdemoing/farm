package com.pal.farm.mappers;


import com.pal.farm.dto.UserDTO;
import com.pal.farm.model.User;


public interface UserMapperService {

	UserDTO map(User u);

	User map(UserDTO dto);

}