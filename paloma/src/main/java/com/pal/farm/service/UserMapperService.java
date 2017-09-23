package com.pal.farm.service;

import com.pal.farm.dto.UserDTO;
import com.pal.farm.model.User;

public interface UserMapperService {

	UserDTO map(User u);

	User map(UserDTO u);

}