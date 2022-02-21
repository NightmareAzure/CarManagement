package com.cm.action;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cm.core.CMError;
import com.cm.service.ChangeSomethingService;

public class ModifyInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			//System.out.println("1!!!!!!!!!!!!");
			String username=request.getSession().getAttribute("username").toString();
			String form=request.getSession().getAttribute("form").toString();
			//System.out.println("1!!!!!!!!!!!!");
			ChangeSomethingService cs=new ChangeSomethingService();
			if(form.equals("Client")){
				String type=request.getParameter("type");
				if(type.equals("password")){
					String oldPwd=request.getParameter("oldPwd");
					String newPwd1=request.getParameter("newPwd1");
					String newPwd2=request.getParameter("newPwd2");
					if(!oldPwd.equals("")&&!newPwd1.equals("")&&!newPwd2.equals("")&&newPwd1.equals(newPwd2)){
						if(cs.ChangeClientPasswordImpl(username, oldPwd, newPwd1)){
							request.getSession().setAttribute("msg", "密码修改成功!");
						}else{
							request.getSession().setAttribute("msg", "密码修改失败!");
						}
					}else{
						request.getSession().setAttribute("msg", "密码输入有误!");
					}
					request.getRequestDispatcher("/ViewUserInfo?type=Mpassword").forward(request, response);
				}else{
					String telephone=request.getParameter("telephone");
					String Etretelephone=request.getParameter("Etretelephone");
					if(cs.ChangeClientTelImpl(username, telephone)){
						if(cs.ChangeClientPhoneImpl(username, Etretelephone)){
							request.getSession().setAttribute("msg", "联系方式修改成功，备用电话修改成功!");
						}else{
							request.getSession().setAttribute("msg", "联系方式修改成功，备用电话修改失败!");
						}
					}else{
						request.getSession().setAttribute("msg", "联系方式备用电话修改失败!");
					}
					request.getRequestDispatcher("/ViewUserInfo?type=MInfo").forward(request, response);
				}
			}else{
				//System.out.println("1!!!!!!!!!!!!");
				String type=request.getParameter("type");
				//System.out.println(type);
				if(type.equals("password")){
					String oldPwd=request.getParameter("oldPwd");
					String newPwd1=request.getParameter("newPwd1");
					String newPwd2=request.getParameter("newPwd2");
					if(!oldPwd.equals("")&&!newPwd1.equals("")&&!newPwd2.equals("")&&newPwd1.equals(newPwd2)){
						if(cs.ChangeServicePasswordImpl(username, oldPwd, newPwd1)){
							request.getSession().setAttribute("msg", "密码修改成功!");
						}
					}
					request.getRequestDispatcher("/ViewUserInfo?type=Mpassword").forward(request, response);
				}else{
					String telephone=request.getParameter("telephone");
					//System.out.println("OKOKOKOKO");
					if(cs.ChangeServiceTelImpl(username, telephone)){
						request.getSession().setAttribute("msg", "联系方式修改成功!");
					}else{
						request.getSession().setAttribute("msg", "联系方式修改失败!");
					}
					request.getRequestDispatcher("/ViewUserInfo?type=MInfo").forward(request, response);
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
			//System.out.println("1!!!!!!!!!!!!");
			String username=request.getSession().getAttribute("username").toString();
			String form=request.getSession().getAttribute("form").toString();
			//System.out.println("1!!!!!!!!!!!!");
			ChangeSomethingService cs=new ChangeSomethingService();
			if(form.equals("Client")){
				String type=request.getParameter("type");
				if(type.equals("password")){
					String oldPwd=request.getParameter("oldPwd");
					String newPwd1=request.getParameter("newPwd1");
					String newPwd2=request.getParameter("newPwd2");
					if(!oldPwd.equals("")&&!newPwd1.equals("")&&!newPwd2.equals("")&&newPwd1.equals(newPwd2)){
						if(cs.ChangeClientPasswordImpl(username, oldPwd, newPwd1)){
							request.getSession().setAttribute("msg", "密码修改成功!");
						}else{
							request.getSession().setAttribute("msg", "密码修改失败!");
						}
					}else{
						request.getSession().setAttribute("msg", "密码输入有误!");
					}
					request.getRequestDispatcher("/ViewUserInfo?type=Mpassword").forward(request, response);
				}else{
					String telephone=request.getParameter("telephone");
					String Etretelephone=request.getParameter("Etretelephone");
					if(cs.ChangeClientTelImpl(username, telephone)){
						if(cs.ChangeClientPhoneImpl(username, Etretelephone)){
							request.getSession().setAttribute("msg", "联系方式修改成功，备用电话修改成功!");
						}else{
							request.getSession().setAttribute("msg", "联系方式修改成功，备用电话修改失败!");
						}
					}else{
						request.getSession().setAttribute("msg", "联系方式备用电话修改失败!");
					}
					request.getRequestDispatcher("/ViewUserInfo?type=MInfo").forward(request, response);
				}
			}else{
				//System.out.println("1!!!!!!!!!!!!");
				String type=request.getParameter("type");
				//System.out.println(type);
				if(type.equals("password")){
					String oldPwd=request.getParameter("oldPwd");
					String newPwd1=request.getParameter("newPwd1");
					String newPwd2=request.getParameter("newPwd2");
					if(!oldPwd.equals("")&&!newPwd1.equals("")&&!newPwd2.equals("")&&newPwd1.equals(newPwd2)){
						if(cs.ChangeServicePasswordImpl(username, oldPwd, newPwd1)){
							request.getSession().setAttribute("msg", "密码修改成功!");
						}else{
							request.getSession().setAttribute("msg", "密码修改失败!");
						}
					}else{
						request.getSession().setAttribute("msg", "密码输入有误!");
					}
					request.getRequestDispatcher("/ViewUserInfo?type=Mpassword").forward(request, response);
				}else{
					String telephone=request.getParameter("telephone");
					//System.out.println("OKOKOKOKO");
					if(cs.ChangeServiceTelImpl(username, telephone)){
						request.getSession().setAttribute("msg", "联系方式修改成功!");
					}else{
						request.getSession().setAttribute("msg", "联系方式修改失败!");
					}
					request.getRequestDispatcher("/ViewUserInfo?type=MInfo").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CMError(e.getMessage());
		}
	}

}
