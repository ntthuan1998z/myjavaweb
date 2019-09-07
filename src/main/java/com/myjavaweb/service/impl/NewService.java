package com.myjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.myjavaweb.dao.iNewDAO;
import com.myjavaweb.dao.impl.NewDAO;
import com.myjavaweb.model.NewModel;
import com.myjavaweb.paging.Pageble;
import com.myjavaweb.service.iNewService;

public class NewService implements iNewService {

	@Inject
	private iNewDAO newDAO;
	@Override
	public List<NewModel> findByCategoryId(Long categoryid) {
		// TODO Auto-generated method stub
		return newDAO.findByCategoryId(categoryid);
	}
	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newId = newDAO.save(newModel);
		return newDAO.findOne(newId);
	}
	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}
	@Override
	public void delete(Long[] ids) {
		for(Long id : ids)
		{
			//delete comment
			//delete news
			newDAO.delete(id);
		}
		
	}
	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return newDAO.findAll(pageble);
	}
	/*
	 * @Override public NewModel findOne(long id) { // TODO Auto-generated method
	 * stub return null; }
	 */
	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}

}
