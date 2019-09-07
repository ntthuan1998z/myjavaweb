package com.myjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myjavaweb.constant.SystemConstant;
import com.myjavaweb.model.NewModel;
import com.myjavaweb.paging.PageRequest;
import com.myjavaweb.paging.Pageble;
import com.myjavaweb.service.iNewService;
import com.myjavaweb.service.impl.NewService;
import com.myjavaweb.sort.Sorter;
import com.myjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private iNewService newService;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		NewModel newModel = FormUtil.toModel(NewModel.class, req);
		Pageble pageble = new PageRequest(newModel.getPage(), newModel.getMaxPageItem(), 
											new Sorter(newModel.getSortName(), newModel.getSortBy()));
		newModel.setListResult(newService.findAll(pageble));
		newModel.setTotalItem(newService.getTotalItem());
		newModel.setTotalPage((int) Math.ceil((double) newModel.getTotalItem() / newModel.getMaxPageItem()));
		req.setAttribute(SystemConstant.MODEL, newModel);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
