package com.cm.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cm.core.CMError;
import com.cm.entity.CarInfo;
import com.cm.service.AddSomethingService;
import com.cm.service.DeleteSomethingService;
import com.cm.service.ViewSomethingService;

public class ManageCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response){

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String username=request.getSession().getAttribute("username").toString();
			String form=request.getSession().getAttribute("form").toString();
			String type=request.getParameter("type");
			request.getSession().setAttribute("msg", "");
			ViewSomethingService vs=new ViewSomethingService();
			AddSomethingService as=new AddSomethingService();
			if(form.equals("Client")){
				if(type.equals("Add")){
					String Code=request.getParameter("Code");
					String Model=request.getParameter("Model");
					String Brand=request.getParameter("Brand");
					String Area=request.getParameter("Area");
					String Date=request.getParameter("Date");
					if(as.AddCarImpl(username,Code, Model, Area, Date, Brand)){
						request.setAttribute("message", "添加车辆成功!");
						request.getRequestDispatcher("/addCars.jsp").forward(request, response);
					}else{
						request.setAttribute("message", "添加车辆失败!");
						request.getRequestDispatcher("/addCars.jsp").forward(request, response);
					}
				}else if(type.equals("Search")){
					List<CarInfo> rs=vs.ViewAllCarInfoImpl(username);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/checkCars.jsp").forward(request, response);
				}else if(type.equals("Check")){//Check
					String CarId=request.getParameter("CarId");
					CarInfo rs=vs.ViewOneCarInfoImpl(CarId);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/serviceCars.jsp").forward(request, response);
				}else if(type.equals("DoingCheck")){//Check
					String CarId=request.getParameter("CarId");
					String Problem=request.getParameter("Problem");
					if(as.AddBillImpl(CarId,Problem)){
						request.setAttribute("message", "维修提交成功!");
					}else{
						request.setAttribute("message", "维修提交失败!");
					}
					request.getRequestDispatcher("/ClientNotice.jsp").forward(request, response);
				}else if(type.equals("Delete")){
					DeleteSomethingService ds=new DeleteSomethingService();
					String[] carIds=request.getParameterValues("delete");
					if(carIds!=null){
						for(String a:carIds){
							if(ds.DeleteCarImpl(a)){
								continue;
							}
							/*else{
								break;
							}*/
						}
					}
					request.getRequestDispatcher("/ManageCar?type=Search").forward(request, response);
				}else{//CreateCheck
					List<CarInfo> rs=vs.ViewUnServiceCarInfoImpl(username);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/service.jsp").forward(request, response);
				}
			}else{
				throw new CMError("用户类型错误！");
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
			String type=request.getParameter("type");
			request.getSession().setAttribute("msg", "");
			ViewSomethingService vs=new ViewSomethingService();
			AddSomethingService as=new AddSomethingService();
			if(form.equals("Client")){
				if(type.equals("Add")){
					String Code=request.getParameter("Code");
					String Model=request.getParameter("Model");
					String Brand=request.getParameter("Brand");
					String Area=request.getParameter("Area");
					String Date=request.getParameter("Date");
					if(as.AddCarImpl(username,Code, Model, Area, Date, Brand)){
						request.setAttribute("message", "添加车辆成功!");
						request.getRequestDispatcher("/addCars.jsp").forward(request, response);
					}else{
						request.setAttribute("message", "添加车辆失败!");
						request.getRequestDispatcher("/addCars.jsp").forward(request, response);
					}
				}else if(type.equals("Search")){
					List<CarInfo> rs=vs.ViewAllCarInfoImpl(username);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/checkCars.jsp").forward(request, response);
				}else if(type.equals("Check")){//Check
					String CarId=request.getParameter("CarId");
					String CarCode=request.getParameter("CarCode");
					request.setAttribute("CarId", CarId);
					request.setAttribute("CarCode", CarCode);
					request.getRequestDispatcher("/serviceCars.jsp").forward(request, response);
				}else if(type.equals("DoingCheck")){//Check
					String CarId=request.getParameter("CarId");
					String Problem=request.getParameter("Problem");
					if(as.AddBillImpl(CarId,Problem)){
						request.setAttribute("message", "维修提交成功!");
					}else{
						request.setAttribute("message", "维修提交失败!");
					}
					request.getRequestDispatcher("/ClientNotice.jsp").forward(request, response);
				}else if(type.equals("Delete")){
					DeleteSomethingService ds=new DeleteSomethingService();
					String[] carIds=request.getParameterValues("delete");
					if(carIds!=null){
						for(String a:carIds){
							if(ds.DeleteCarImpl(a)){
								continue;
							}else{
								break;
							}
						}
					}
					request.getRequestDispatcher("/ManageCar?type=Search").forward(request, response);
				}else{//CreateCheck
					List<CarInfo> rs=vs.ViewUnServiceCarInfoImpl(username);
					request.setAttribute("info", rs);
					request.getRequestDispatcher("/service.jsp").forward(request, response);
				}
			}else{
				throw new CMError("用户类型错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CMError(e.getMessage());
		}
	}

}
