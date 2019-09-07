package com.myjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myjavaweb.model.UserModel;
import com.myjavaweb.service.iCategoryService;
import com.myjavaweb.service.iNewService;
import com.myjavaweb.service.iUserService;
import com.myjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap"})
public class HomeController extends HttpServlet {
	

	@Inject
	private iNewService newService;
	@Inject
	private iCategoryService categoryService;
	@Inject
	private iUserService userService;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String title = "Bai viet 4";
//		String content = "Basaas";
//		Long categoryid = 1L;
//		NewModel newModel = new NewModel();
//		newModel.setTitle(title);
//		newModel.setContent(content);
//		newModel.setCategoryId(categoryid);
//		newService.save(newModel);
//		req.setAttribute("news", newService.findByCategoryId(categoryid));
//		req.setAttribute("categories", categoryService.findAll());
		String action = req.getParameter("action");
		if(action!=null)
		{
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
			if (model != null)
			{
				if(model.getRole().getCode().equals("USER"))
				{
					resp.sendRedirect(req.getContextPath()+"/trang-chu");					
				}
				else if(model.getRole().getCode().equals("ADMIN"))
				{
					resp.sendRedirect(req.getContextPath()+"/admin-trang-chu");
				}
			}
			else
			{
				resp.sendRedirect(req.getContextPath()+"dang-nhap?action=login");
			}
			
		}
	}
	
	
}
