package com.pal.farm.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pal.farm.dto.MessageDTO;

import java.lang.NumberFormatException;
import org.dozer.converters.ConversionException;
import javax.validation.ConstraintViolationException;                 //interpolatedMessage='no puede ser null', propertyPath=username
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;    // cuando asigno animales que ya pertenecen a otro usuario
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;


@ControllerAdvice(basePackages = { "com.pal.farm.controller" })
public class ErrorControllerImpl implements ErrorController {

//	@ResponseBody
//	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public MessageDTO errorBadRequest(Exception e) {
//		return new MessageDTO(e.getMessage());
//	}
	
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
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public MessageDTO errorAssociation(Exception e) {
		return new MessageDTO(e.getMessage());
	}

	@Override
	@ResponseBody
	@ExceptionHandler(InvalidRequestException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public MessageDTO errorCannotProceed(Exception e) {
		return new MessageDTO("No permitido");
	}

	@Override
	@ResponseBody
	@ExceptionHandler(NotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public MessageDTO errorNotFound(Exception e) {
		return new MessageDTO("No encontrado");
	}

}
