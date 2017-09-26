package com.pal.farm.dto;


import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class UserProfitsDTO implements Serializable {
	
	private static final long serialVersionUID = 6189387863660917415L;

	private String user;
	
	private String profits;
}
