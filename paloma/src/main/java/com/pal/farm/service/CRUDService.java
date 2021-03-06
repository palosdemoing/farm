package com.pal.farm.service;


import java.io.Serializable;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.data.domain.Pageable;

import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;


public interface CRUDService<T, ID extends Serializable> {

	T create(T t) throws NotFound, AssociationNotPermittedException;

	void delete(T t) throws InvalidRequestException;

	void update(T t) throws NotFound, AssociationNotPermittedException;

	List<T> getAll(Pageable pageable) throws CannotProceed;

	T findById(ID id);

}
