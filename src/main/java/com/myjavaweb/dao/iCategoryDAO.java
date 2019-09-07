package com.myjavaweb.dao;

import java.util.List;

import com.myjavaweb.model.CategoryModel;

public interface iCategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
}
