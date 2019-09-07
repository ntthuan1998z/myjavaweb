package com.myjavaweb.dao;

import java.util.List;

import com.myjavaweb.model.NewModel;
import com.myjavaweb.paging.Pageble;

public interface iNewDAO extends GenericDAO<NewModel> {
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryid);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(Long id);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}
