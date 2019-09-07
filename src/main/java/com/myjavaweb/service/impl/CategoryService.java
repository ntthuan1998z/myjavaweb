package com.myjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.myjavaweb.dao.iCategoryDAO;
import com.myjavaweb.model.CategoryModel;
import com.myjavaweb.service.iCategoryService;

public class CategoryService implements iCategoryService {

	
	/*
	 * private iCategoryDAO categoryDAO;
	 * 
	 * public CategoryService() { categoryDAO = new CategoryDAO(); }
	 */
	@Inject
	private iCategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

}
