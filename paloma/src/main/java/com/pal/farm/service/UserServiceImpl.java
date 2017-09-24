package com.pal.farm.service;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.UserDAO;
import com.pal.farm.dto.UserDTO;
import com.pal.farm.mappers.UserMapperService;
import com.pal.farm.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapperService userMapper;

	@Autowired
	private UserDAO userDao;

	@Override
	public UserDTO create(UserDTO t) {
		return userMapper.map( userDao.save( userMapper.map(t) ) );
	}

	@Override
	public void delete(UserDTO t, Integer id) {
		final User u = userMapper.map(t);
		u.setIdUser(id);
		userDao.delete(u);
	}

	@Override
	public UserDTO update(UserDTO t, Integer id) {
		final User u = userMapper.map(t);
		u.setIdUser(id);
		return userMapper.map( userDao.save(u) );
	}

	@Override
	public List<UserDTO> getAll(Pageable pageable) {
		final List<UserDTO> users = new ArrayList<>();
		userDao.findAll(pageable).forEach(u -> users.add( userMapper.map(u) ));
		return users;
	}

	@Override
	public UserDTO findById(Integer id) {
		return userMapper.map( userDao.findOne(id) );
	}

	@Override
	public UserDTO findByUsername(String name) throws NotFound {
		return userMapper.map( userDao.findUserByUsername(name) );
	}

	@Override
	public List<User> earnsByUser(Integer id) {
		List<User> users = new ArrayList<>();
		if (userDao.findOne(id) != null) {
//			users = userDao.findUserWherePriceXXXXXXXXXXXX(id);
			return users;
		}
		return users;
	}

}
