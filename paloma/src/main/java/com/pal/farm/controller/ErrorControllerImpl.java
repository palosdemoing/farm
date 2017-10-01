package com.pal.farm.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pal.farm.dto.MessageDTO;

import javax.validation.ConstraintViolationException;                 //interpolatedMessage='no puede ser null', propertyPath=username
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;


@ControllerAdvice(basePackages = { "com.pal.farm.controller", "com.pal.farm.mapper", "com.pal.farm.service" })
public class ErrorControllerImpl implements ErrorController {
	
	@Override
	@ResponseBody
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MessageDTO errorGetArgs(Exception e) {
		return new MessageDTO(e.getMessage());
	}
	
	@Override
	@ResponseBody
	@ExceptionHandler(AssociationNotPermittedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MessageDTO errorAssociation(Exception e) {
		return new MessageDTO(e.getMessage());
	}

	@Override
	@ResponseBody
	@ExceptionHandler(InvalidRequestException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public MessageDTO errorCannotProceed(Exception e) {
		return new MessageDTO(e.getMessage());
	}

	@Override
	@ResponseBody
	@ExceptionHandler(NotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public MessageDTO errorNotFound(Exception e) {
		return new MessageDTO("No encontrado alguno de los elementos indicados");
	}

}
