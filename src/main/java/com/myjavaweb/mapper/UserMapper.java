package com.myjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.myjavaweb.model.RoleModel;
import com.myjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {
	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel user = new UserModel();
		try {
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setFullName(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			RoleModel role = new RoleModel();
			role.setCode(resultSet.getString("code"));
			role.setName(resultSet.getString("name"));
			user.setRole(role);
			
			return user;
		} catch (SQLException e) {
			return null;
		}
	}
}
