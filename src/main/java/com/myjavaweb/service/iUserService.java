package com.myjavaweb.service;

import com.myjavaweb.model.UserModel;

public interface iUserService {
	UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status);

}
