package com.pal.farm.controller;

import java.io.Serializable;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;


public interface CRUDController <T, ID extends Serializable>{

	T create(T t) throws NotFound, AssociationNotPermittedException;

	void delete(T t, ID id) throws NotFound, InvalidRequestException, AssociationNotPermittedException;

	void update(T t, ID id) throws NotFound, AssociationNotPermittedException;

	List<T> getAll(Integer page, Integer size) throws CannotProceed;

	T findById(Integer id) throws NotFound;

}