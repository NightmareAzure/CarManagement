package com.cm.action;

import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cm.core.CMError;
import com.cm.service.ViewSomethingService;

public class ViewBillServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String type=request.getParameter("type");
			String username=request.getSession().getAttribute("username").toString();
			String form=request.getSession().getAttribute("form").toString();
			ViewSomethingService vs=new ViewSomethingService();
			request.getSession().setAttribute("msg", "");
			if(form.equals("Client")){
				if(type.equals("NotFinished")){
					List<Object[]> rs=vs.ViewBillImpl(username, 0);//正在维修的
					List<Object[]> rs1=vs.ViewBillImpl(username, -1);//未维修的
					if(rs1!=null){
						for(Object[] flag:rs1){
							rs.add(flag);
						}
					}
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/notFinishList.jsp").forward(request, response);
				}else{//Finished
					List<Object[]> rs=vs.ViewBillImpl(username, 1);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/clientHistory.jsp").forward(request, response);
				}
			}else{
				if(type.equals("NotFinished")){
					List<Object[]> rs=vs.ViewBillImpl(-1);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/ScheckList.jsp").forward(request, response);
				}else if(type.equals("Finished")){
					List<Object[]> rs=vs.ViewAllServiceBillImpl(username, 1);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/serviceHistory.jsp").forward(request, response);
				}else{//Doing
					//System.out.println("OKOK");
					List<Object[]> rs=vs.ViewAllServiceBillImpl(username, 0);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/ScheckList.jsp").forward(request, response);
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
				String username=request.getSession().getAttribute("username").toString();
				String form=request.getSession().getAttribute("form").toString();
				ViewSomethingService vs=new ViewSomethingService();
				if(form.equals("Client")){
					if(type.equals("NotFinished")){
						List<Object[]> rs=vs.ViewBillImpl(username, 0);//正在维修的
						List<Object[]> rs1=vs.ViewBillImpl(username, -1);//未维修的
						for(Object[] flag:rs1){
							rs.add(flag);
						}
						request.setAttribute("info", rs);
						request.getRequestDispatcher("/notFinishList.jsp").forward(request, response);
					}else{//Finished
						List<Object[]> rs=vs.ViewBillImpl(username, 1);
						request.setAttribute("info", rs);
						request.getRequestDispatcher("/clientHistory.jsp").forward(request, response);
					}
				}else{
					if(type.equals("NotFinished")){
						List<Object[]> rs=vs.ViewBillImpl(-1);
						request.setAttribute("info", rs);
						request.getRequestDispatcher("/ScheckList.jsp").forward(request, response);
					}else if(type.equals("Finished")){
						List<Object[]> rs=vs.ViewAllServiceBillImpl(username, 1);
						request.setAttribute("info", rs);
						request.getRequestDispatcher("/serviceHistory.jsp").forward(request, response);
					}else{//Doing
						List<Object[]> rs=vs.ViewAllServiceBillImpl(username, 0);
						request.setAttribute("info", rs);
						request.getRequestDispatcher("/ScheckList.jsp").forward(request, response);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new CMError(e.getMessage());
			}

	}

}
