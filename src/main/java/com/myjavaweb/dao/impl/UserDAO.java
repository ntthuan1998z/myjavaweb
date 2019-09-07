package com.myjavaweb.dao.impl;

import java.util.List;

import com.myjavaweb.dao.iUserDAO;
import com.myjavaweb.mapper.UserMapper;
import com.myjavaweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements iUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.role.id");
		sql.append(" WHERE USERNAME= ? AND PASSWORD = ? AND STATUS = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), username, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

}
