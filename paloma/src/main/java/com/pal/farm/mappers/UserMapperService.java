package com.pal.farm.mappers;


import com.pal.farm.dto.UserDTO;
import com.pal.farm.model.User;


public interface UserMapperService { // extends MapperService<User, UserDTO> {

	UserDTO toDTO(User u);

	User toModel(UserDTO dto);

}