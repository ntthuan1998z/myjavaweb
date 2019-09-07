package com.myjavaweb.dao.impl;

import java.util.List;

import com.myjavaweb.dao.iCategoryDAO;
import com.myjavaweb.mapper.CategoryMapper;
import com.myjavaweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements iCategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM Category";
		return query(sql, new CategoryMapper());
	}
}
