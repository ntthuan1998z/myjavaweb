package com.myjavaweb.service.impl;

import javax.inject.Inject;

import com.myjavaweb.dao.iUserDAO;
import com.myjavaweb.model.UserModel;
import com.myjavaweb.service.iUserService;

public class UserService implements iUserService {

	@Inject
	private iUserDAO userDAO;
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(username, password, status);
	}

}
