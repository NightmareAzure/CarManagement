package com.cm.action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cm.core.CMError;

public class LoginOutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			request.getSession().setAttribute("form", null);
			request.getSession().setAttribute("IsLogin", false);
			request.getSession().setAttribute("username", null);
			request.getSession().setAttribute("msg", "");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CMError(e.getMessage());
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			request.getSession().setAttribute("form", null);
			request.getSession().setAttribute("IsLogin", false);
			request.getSession().setAttribute("username", null);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CMError(e.getMessage());
		}

	}

}
