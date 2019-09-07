package com.myjavaweb.dao;

import java.util.List;

import com.myjavaweb.model.NewModel;
import com.myjavaweb.model.UserModel;
import com.myjavaweb.paging.Pageble;

public interface iUserDAO extends GenericDAO<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer Status);
}
