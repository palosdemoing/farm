package com.pal.farm.service;


import java.io.Serializable;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.data.domain.Pageable;


public interface CRUDService<T, ID extends Serializable> {

	T create(T t);

	void delete(T t) throws CannotProceed;

	void update(T t) throws NotFound;

	List<T> getAll(Pageable pageable) throws CannotProceed;

	T findById(ID id) throws NotFound;

}