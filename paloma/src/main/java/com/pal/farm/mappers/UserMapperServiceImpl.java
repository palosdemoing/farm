package com.pal.farm.mappers;


import org.springframework.stereotype.Service;

import com.pal.farm.dto.UserDTO;
import com.pal.farm.model.User;


@Service
public class UserMapperServiceImpl implements UserMapperService{

	@Override
	public UserDTO map(User u) {
		final UserDTO dto = new UserDTO(u.getUsername(), u.getEmail());
		return dto;
	}

	@Override
	public User map(UserDTO dto) {
		final User u = new User(dto.getUsername(), dto.getEmail());
		return u;
	}

}
