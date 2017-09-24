package com.pal.farm.dto;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 5120766028716904643L;

	private String username;
	
	private String email;

}
