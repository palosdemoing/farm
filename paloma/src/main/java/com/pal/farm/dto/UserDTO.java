package com.pal.farm.dto;


import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 5120766028716904643L;

	private String username;

	private List<Integer> animals;

}
