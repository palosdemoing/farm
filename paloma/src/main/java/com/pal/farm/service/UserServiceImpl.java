package com.pal.farm.service;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.UserDAO;
import com.pal.farm.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	public User create(User t) {
		return userDao.save(t);
	}

	@Override
	public void delete(User t) {
		userDao.delete(t);
	}

	@Override
	public User update(User t) {
		return userDao.save(t);
	}

	@Override
	public List<User> getAll(Pageable pageable) {
		final List<User> users = new ArrayList<>();
		userDao.findAll(pageable).forEach(u -> users.add(u));
		return users;
	}

	@Override
	public User findById(Integer id) {
		return userDao.findOne(id);
	}

	@Override
	public User findByUsername(String name) throws NotFound {
		return userDao.findUserByUsername(name);
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
