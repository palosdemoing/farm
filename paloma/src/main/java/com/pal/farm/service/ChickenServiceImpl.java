package com.pal.farm.service;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.ChickenDAO;
import com.pal.farm.dto.ChickenDTO;
import com.pal.farm.mappers.ChickenMapperService;
import com.pal.farm.model.Chicken;


@Service
public class ChickenServiceImpl implements ChickenService {

	@Autowired
	private ChickenMapperService chickenMapper;
	
	@Autowired
	private ChickenDAO chickenDao;

	@Override
	public ChickenDTO create(ChickenDTO t) throws NotFound {
		return chickenMapper.map(chickenDao.save( chickenMapper.map(t) ));	
	}

	@Override
	public void delete(ChickenDTO t, Integer id) {
		final Chicken c = chickenMapper.map(t);
		c.setIdAnimal(id);
		chickenDao.delete( chickenMapper.map(t) );  // error 401
	}

	@Override
	public ChickenDTO update(ChickenDTO t, Integer id) throws NotFound {
		final Chicken c = chickenMapper.map(t);
		c.setIdAnimal(id);
		if ( chickenDao.findOne(c.getIdAnimal()) instanceof Chicken ) {
			throw new NotFound();
		}
		return chickenMapper.map(chickenDao.save(c));
	}

	@Override
	public List<ChickenDTO> getAll(Pageable pageable) {
		final List<ChickenDTO> chickens = new ArrayList<>();
		chickenDao.findAll(pageable).forEach(c -> {
			if (c instanceof Chicken) {
				chickens.add( chickenMapper.map((Chicken) c) );
			}
		});
		return chickens;
	}

	@Override
	public ChickenDTO findById(Integer id) {
		return chickenMapper.map( (Chicken) chickenDao.findOne(id) );
	}

	@Override
	public List<ChickenDTO> findByTypeAndFrecuency(String type, String frecuency) {
		final List<ChickenDTO> chickens = new ArrayList<>();
		chickenDao.findOneByTypeAndFrecuency(type, frecuency).forEach(c -> chickens.add( chickenMapper.map(c) ));
		return chickens;
	}

}
