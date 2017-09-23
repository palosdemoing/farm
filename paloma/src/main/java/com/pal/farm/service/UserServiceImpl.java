package com.pal.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pal.farm.dao.UserDao;
import com.pal.farm.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public User create(User t) {
		return dao.save(t);
	}

	@Override
	public void delete(User t) {
		dao.delete(t);
	}

	@Override
	public User update(User t) {
		return dao.save(t);
	}

	@Override
	public List<User> getAll(Pageable pageable) {
		final List<User> users = new ArrayList<>();
		dao.findAll(pageable).forEach(u -> users.add(u));
		return users;
	}

	@Override
	public User findById(Integer id) {
		return dao.findOne(id);
	}

}
