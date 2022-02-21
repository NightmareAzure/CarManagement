package com.cm.action;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cm.core.CMError;
import com.cm.entity.ClientInfo;
import com.cm.entity.ServicemanInfo;
import com.cm.service.ViewSomethingService;

public class ViewUserInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String username=request.getSession().getAttribute("username").toString();
			String form=request.getSession().getAttribute("form").toString();
			//System.out.println("form="+form);
			ViewSomethingService vs=new ViewSomethingService();
			if(form.equals("Client")){
				String type=request.getParameter("type");
				if(type.equals("Mpassword")){
					System.out.println("kelley");
					request.getRequestDispatcher("/CmodifyPassword.jsp").forward(request, response);
				}else if(type.equals("MInfo")){
					ClientInfo rs=vs.ViewClientInfoImpl(username);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/CcheckInfo.jsp").forward(request, response);
				}else if(type.equals("Info")){
					//System.out.println("dsssssssss");
					ClientInfo rs=vs.ViewClientInfoImpl(username);
					request.setAttribute("info", rs);
					request.getSession().setAttribute("msg", "");
					request.getRequestDispatcher("/CcheckInfo.jsp").forward(request, response);
				}else{
					request.getSession().setAttribute("msg", "");
					request.getRequestDispatcher("/CmodifyPassword.jsp").forward(request, response);
				}
			}else{
				String type=request.getParameter("type");
				if(type.equals("Mpassword")){
					request.getRequestDispatcher("/SmodifyPassword.jsp").forward(request, response);
				}else if(type.equals("MInfo")){
					ServicemanInfo rs=vs.ViewServiceManInfoImpl(username);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/ScheckInfo.jsp").forward(request, response);
				}else if(type.equals("Info")){
					ServicemanInfo rs=vs.ViewServiceManInfoImpl(username);
					//System.out.println("kelley!!!!!!!");
				    request.setAttribute("info", rs);
				    //System.out.println(rs.getServicemanId()+"!!!!!!!!!!!!!!!!");
					request.getSession().setAttribute("msg", "");
					request.getRequestDispatcher("/ScheckInfo.jsp").forward(request, response);
				}else{
					request.getSession().setAttribute("msg", "");
					request.getRequestDispatcher("/SmodifyPassword.jsp").forward(request, response);
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
			String username=request.getSession().getAttribute("username").toString();
			String form=request.getSession().getAttribute("form").toString();
			//System.out.println("form="+form);
			ViewSomethingService vs=new ViewSomethingService();
			if(form.equals("Client")){
				String type=request.getParameter("type");
				if(type.equals("Mpassword")){
					request.getRequestDispatcher("/CmodifyPassword.jsp").forward(request, response);
				}else if(type.equals("MInfo")){
					ClientInfo rs=vs.ViewClientInfoImpl(username);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/CcheckInfo.jsp").forward(request, response);
				}else if(type.equals("Info")){
					request.getSession().setAttribute("msg", "");
					request.getRequestDispatcher("/CcheckInfo.jsp").forward(request, response);
				}else{
					request.getSession().setAttribute("msg", "");
					request.getRequestDispatcher("/CmodifyPassword.jsp").forward(request, response);
				}
			}else{
				String type=request.getParameter("type");
				//System.out.println("type="+type);
				if(type.equals("Mpassword")){
					//System.out.println("0001111");
					request.getRequestDispatcher("/SmodifyPassword.jsp").forward(request, response);
				}else if(type.equals("MInfo")){
					ServicemanInfo rs=vs.ViewServiceManInfoImpl(username);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/ScheckInfo.jsp").forward(request, response);
				}else if(type.equals("Info")){
					request.getSession().setAttribute("msg", "");
					request.getRequestDispatcher("/ScheckInfo.jsp").forward(request, response);
				}else{
					request.getSession().setAttribute("msg", "");
					request.getRequestDispatcher("/SmodifyPassword.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CMError(e.getMessage());
		}

	}

}
