package com.pal.farm.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pal.farm.dto.MessageDTO;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice(basePackages = { "com.pal.farm.controller" })
public class ErrorControllerImpl implements ErrorController {

//	@ResponseBody
//	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public MessageDTO errorBadRequest(Exception e) {
//		return new MessageDTO(e.getMessage());
//	}
	
	@ResponseBody
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MessageDTO errorGetArgs(Exception e) {
		return new MessageDTO(e.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(CannotProceed.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public MessageDTO errorCannotProceed(Exception e) {
		return new MessageDTO("No permitido");
	}

	@ResponseBody
	@ExceptionHandler(NotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public MessageDTO errorNotFound(Exception e) {
		return new MessageDTO("No encontrado");
	}

}
