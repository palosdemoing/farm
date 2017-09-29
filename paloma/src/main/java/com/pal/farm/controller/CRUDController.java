package com.pal.farm.controller;

import java.io.Serializable;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;


public interface CRUDController <T, ID extends Serializable>{

	T create(T t);

	void delete(T t, ID id) throws CannotProceed;

	void update(T t, Integer id) throws NotFound;

	List<T> getAll(Integer page, Integer size) throws CannotProceed;

	T findById(Integer id) throws NotFound;


}