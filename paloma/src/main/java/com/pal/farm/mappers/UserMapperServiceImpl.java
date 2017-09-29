package com.pal.farm.mappers;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pal.farm.dto.UserDTO;
import com.pal.farm.model.User;


@Component
public class UserMapperServiceImpl implements UserMapperService {  // extends MapperService<User, UserDTO>

	@Override
	public UserDTO toDTO(User c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User toModel(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
