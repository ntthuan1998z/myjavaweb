package com.myjavaweb.service;

import java.util.List;

import com.myjavaweb.model.NewModel;
import com.myjavaweb.paging.Pageble;

public interface iNewService {
	List<NewModel> findByCategoryId(Long categoryid);
	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(Long[] ids);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
	//NewModel findOne(long id);
}
