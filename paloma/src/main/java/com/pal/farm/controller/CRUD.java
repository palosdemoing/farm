package com.pal.farm.controller;

import java.io.Serializable;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.springframework.data.domain.Pageable;


public interface CRUD<T, ID extends Serializable> {

	T create(T t) throws NotFound;

	void delete(T t) throws CannotProceed;

	T update(T t) throws CannotProceed;

	List<T> getAll(Pageable pageable) throws NotFound;

	T findById(ID id) throws NotFound;

}
