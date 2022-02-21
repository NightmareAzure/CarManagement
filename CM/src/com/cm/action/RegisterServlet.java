package com.cm.action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cm.core.CMError;
import com.cm.service.RegisterService;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String type=request.getParameter("type");
			RegisterService rs=new RegisterService();
			if(type!=null){
				if(type.equals("Client")){
					String id=request.getParameter("id");
					String username=request.getParameter("username");
					String pwd=request.getParameter("pwd");
					String sex=request.getParameter("sex");
					String idCardNo=request.getParameter("idCardNo");
					String telephoneNo=request.getParameter("telephoneNo");
					String extraTelephoneNo=request.getParameter("extraTelephoneNo");
					int flag=rs.ClientRegisterImpl(id, username, pwd, sex, telephoneNo, idCardNo, extraTelephoneNo);
					if(flag==1){
						request.setAttribute("msg", "注册成功！");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}else if(flag==-1){
						request.setAttribute("msg", "注册失败,用户名已存在！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}else if(flag==-2){
						request.setAttribute("msg", "注册失败,身份证号已存在！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}else{
						request.setAttribute("msg", "注册失败,系统错误！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}
				}else{
					System.out.println("dsadsa");
					String id=request.getParameter("id");
					String username=request.getParameter("username");
					String pwd=request.getParameter("pwd");
					String sex=request.getParameter("sex");
					String idCardNo=request.getParameter("idCardNo");
					String attr=request.getParameter("attr");
					String telephoneNo=request.getParameter("telephoneNo");
					int flag=rs.ServicemanRegisterImpl(id, username, pwd, sex, telephoneNo, idCardNo, attr);
					if(flag==1){
						request.setAttribute("msg", "注册成功！");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}else if(flag==-1){
						request.setAttribute("msg", "注册失败,用户名已存在！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}else if(flag==-2){
						request.setAttribute("msg", "注册失败,身份证号已存在！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}else{
						request.setAttribute("msg", "注册失败,系统错误！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}
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
			String type=request.getParameter("type");
			RegisterService rs=new RegisterService();
			if(type!=null){
				if(type.equals("Client")){
					String id=request.getParameter("id");
					String username=request.getParameter("username");
					String pwd=request.getParameter("pwd");
					String sex=request.getParameter("sex");
					String idCardNo=request.getParameter("idCardNo");
					String telephoneNo=request.getParameter("telephoneNo");
					String extraTelephoneNo=request.getParameter("extraTelephoneNo");
					int flag=rs.ClientRegisterImpl(id, username, pwd, sex, telephoneNo, idCardNo, extraTelephoneNo);
					if(flag==1){
						request.setAttribute("msg", "注册成功！");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}else if(flag==-1){
						request.setAttribute("msg", "注册失败,用户名已存在！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}else if(flag==-2){
						request.setAttribute("msg", "注册失败,身份证号已存在！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}else{
						request.setAttribute("msg", "注册失败,系统错误！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}
				}else{
					System.out.println("dsadsa");
					String id=request.getParameter("id");
					String username=request.getParameter("username");
					String pwd=request.getParameter("pwd");
					String sex=request.getParameter("sex");
					String idCardNo=request.getParameter("idCardNo");
					String attr=request.getParameter("attr");
					String telephoneNo=request.getParameter("telephoneNo");
					int flag=rs.ServicemanRegisterImpl(id, username, pwd, sex, telephoneNo, idCardNo, attr);
					if(flag==1){
						request.setAttribute("msg", "注册成功！");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}else if(flag==-1){
						request.setAttribute("msg", "注册失败,用户名已存在！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}else if(flag==-2){
						request.setAttribute("msg", "注册失败,身份证号已存在！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}else{
						request.setAttribute("msg", "注册失败,系统错误！");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CMError(e.getMessage());
		}

	}

}
