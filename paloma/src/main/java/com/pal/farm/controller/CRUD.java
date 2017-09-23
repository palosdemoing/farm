package com.pal.farm.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;


public interface CRUD<T, ID extends Serializable> {

	T create(T t);

	void delete(T t);

	T update(T t);

	List<T> getAll(Pageable pageable);

	T findById(ID id);

}
