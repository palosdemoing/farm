package com.pal.farm.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MessageDTO implements Serializable {
	
	private static final long serialVersionUID = 115899218769524323L;
	
	private String message;

}