package com.pal.farm.service;


import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.UserDAO;
import com.pal.farm.exception.AssociationNotPermittedException;
import com.pal.farm.exception.InvalidRequestException;
import com.pal.farm.model.User;

import lombok.extern.slf4j.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	public User create(User u) throws NotFound, AssociationNotPermittedException {
		return userDao.save(u);
	}

	@Override
	public void delete(User u) throws InvalidRequestException {
		userDao.delete(u);
	}

	@Override
	public void update(User u) throws NotFound, AssociationNotPermittedException {		
		final User current = findById(u.getIdUser());
		if (current == null) {
			throw new NotFound();
		}
		if (u.getUsername() != null) {
			current.setUsername(u.getUsername());
		}
		userDao.save(current);
	}

	@Override
	public List<User> getAll(Pageable pageable) throws CannotProceed {
		if (pageable.getPageSize() > 10) {
			throw new CannotProceed();
		}
		final List<User> users = new ArrayList<>();
		userDao.findAll(pageable).forEach(u -> users.add(u) );
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

}
