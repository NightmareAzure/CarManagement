package com.cm.action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cm.core.CMError;
import com.cm.service.LoginService;


public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String username=request.getParameter("username");
			String pwd=request.getParameter("pwd");
			String type=request.getParameter("type");
			LoginService a=new LoginService();
			if(username.equals("")){
				request.setAttribute("msg", "用户名不能为空！");
			}else if(pwd.equals("")){
				request.setAttribute("msg", "密码不能为空！");
			}else if(type.equals("")){
				request.setAttribute("msg", "类型不能为空！");
			}else{
				if(a.LoginImpl(username, pwd, type)){
					request.setAttribute("msg", "登陆成功"+username);
					request.getSession().setAttribute("username", username);
					request.getSession().setAttribute("IsLogin", true);
					if(type.equals("Client")){
						request.getSession().setAttribute("form", "Client");
						request.getRequestDispatcher("/clientLogin.jsp").forward(request, response);
					}else{
						request.getSession().setAttribute("form", "ServiceMan");
						request.getRequestDispatcher("/serviceManLogin.jsp").forward(request, response);
					}
				}else{ 
					request.setAttribute("msg", "登陆失败,请重新登陆！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CMError(e.getMessage());
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response){


			try {
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				String username=request.getParameter("username");
				String pwd=request.getParameter("pwd");
				String type=request.getParameter("type");
				LoginService a=new LoginService();
				if(username.equals("")){
					request.setAttribute("msg", "用户名不能为空！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else if(pwd.equals("")){
					request.setAttribute("msg", "密码不能为空！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else if(type.equals("")){
					request.setAttribute("msg", "类型不能为空！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else{
					if(a.LoginImpl(username, pwd, type)){
						request.setAttribute("msg", "登陆成功"+username);
						request.getSession().setAttribute("username", username);
						request.getSession().setAttribute("IsLogin", true);
						if(type.equals("Client")){
							request.getSession().setAttribute("form", "Client");
							request.getRequestDispatcher("/clientLogin.jsp").forward(request, response);
						}else{
							request.getSession().setAttribute("form", "ServiceMan");
							request.getRequestDispatcher("/serviceManLogin.jsp").forward(request, response);
						}
					}else{ 
						request.setAttribute("msg", "登陆失败,请重新登陆！");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new CMError(e.getMessage());
			}

	}

}
