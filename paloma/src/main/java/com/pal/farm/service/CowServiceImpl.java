package com.pal.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.CowDAO;
import com.pal.farm.dto.CowDTO;
import com.pal.farm.mappers.CowMapperService;
import com.pal.farm.model.Cow;

@Service
public class CowServiceImpl implements CowService {

	@Autowired
	private CowMapperService cowMapper;
	
	@Autowired
	private CowDAO cowDao;

	@Override
	public CowDTO create(CowDTO t) {
		return cowMapper.map(cowDao.save( cowMapper.map(t) ));
	}

	@Override
	public void delete(CowDTO t, Integer id) {
		final Cow c = cowMapper.map(t);
		c.setIdAnimal(id);
		cowDao.delete(c);  // error 401
	}

	@Override
	public CowDTO update(CowDTO t, Integer id) throws NotFound {
		final Cow c = cowMapper.map(t);
		c.setIdAnimal(id);
		if ( cowDao.findOne(c.getIdAnimal()) instanceof Cow ) {
			throw new NotFound();
		}
		return cowMapper.map(cowDao.save(c));
	}

	@Override
	public List<CowDTO> getAll(Pageable pageable) {
		final List<CowDTO> cows = new ArrayList<>();
		cowDao.findAll(pageable).forEach(c -> {
			if (c instanceof Cow) {
				cows.add( cowMapper.map((Cow) c) );
			}
		});
		return cows;
	}

	@Override
	public CowDTO findById(Integer id) {
		return cowMapper.map( (Cow) cowDao.findOne(id) );
	}

	@Override
	public List<CowDTO> findByTypeAndFrecuency(String type, String frecuency) {
		final List<CowDTO> cows = new ArrayList<>();
		cowDao.findOneByTypeAndFrecuency(type, frecuency).forEach(c -> cows.add( cowMapper.map(c) ));
		return cows;
	}
	
}
