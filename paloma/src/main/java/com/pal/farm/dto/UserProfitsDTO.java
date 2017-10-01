package com.pal.farm.dto;


import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;


@NoArgsConstructor
@Data
public class UserProfitsDTO implements Serializable {

	private static final long serialVersionUID = 6189387863660917415L;
	
	private Double profits;
}
