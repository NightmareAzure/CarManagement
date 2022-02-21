package com.cm.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cm.core.CMError;
import com.cm.entity.CarInfo;
import com.cm.entity.Part;
import com.cm.service.AddSomethingService;
import com.cm.service.DeleteSomethingService;
import com.cm.service.ViewSomethingService;

public class ManagePartServlet extends HttpServlet {


		public void doGet(HttpServletRequest request, HttpServletResponse response){

			try {
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				//String username=request.getSession().getAttribute("username").toString();
				String form=request.getSession().getAttribute("form").toString();
				String type=request.getParameter("type");
				request.getSession().setAttribute("msg", "");
				ViewSomethingService vs=new ViewSomethingService();
				AddSomethingService as=new AddSomethingService();
				if(form.equals("ServiceMan")){
					if(type.equals("Add")){
						String componnentCode=request.getParameter("componnentCode");
						String manufacturer=request.getParameter("manufacturer");
						String price=request.getParameter("price");
						String produceArea=request.getParameter("produceArea");
						String num=request.getParameter("num");
						if(as.AddPartImpl(componnentCode, num, price, manufacturer, produceArea)){
							request.setAttribute("message", "添加零件成功!");
							request.getRequestDispatcher("/addComponent.jsp").forward(request, response);
						}else{
							request.setAttribute("message", "添加零件失败!");
							request.getRequestDispatcher("/addComponent.jsp").forward(request, response);
						}
					}else if(type.equals("Search")){
						List<Part> rs=vs.ViewAllPartInfoImpl();
						request.setAttribute("info", rs);
						request.getRequestDispatcher("/checkComponent.jsp").forward(request, response);
					}else if(type.equals("Delete")){
						DeleteSomethingService ds=new DeleteSomethingService();
						String[] partIds=request.getParameterValues("delete");
						if(partIds!=null){
							for(String a:partIds){
								if(ds.DeletePartImpl(a)){
									continue;
								}else{
									break;
								}
							}
						}
						request.getRequestDispatcher("/ManagePart?type=Search").forward(request, response);
					}else if(type.equals("CreateModify")){//Modify
						String PartModel=request.getParameter("PartModel");
						Part rs=vs.ViewOnePartInfoImpl(PartModel);
						request.setAttribute("info", rs);
						request.getRequestDispatcher("/modifyNum.jsp").forward(request, response);
					}else{//Modify
						String PartModel=request.getParameter("PartModel");
						String AddNum=request.getParameter("AddNum");
						if(as.AddPartImpl(PartModel, AddNum)){
							request.getRequestDispatcher("/ManagePart?type=Search").forward(request, response);
						}else{
							request.setAttribute("message", "数量添加失败!");
							request.getRequestDispatcher("/ManagePart?type=CreateModify").forward(request, response);
						}
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
				String form=request.getSession().getAttribute("form").toString();
				String type=request.getParameter("type");
				request.getSession().setAttribute("msg", "");
				ViewSomethingService vs=new ViewSomethingService();
				AddSomethingService as=new AddSomethingService();
				if(form.equals("ServiceMan")){
					if(type.equals("Add")){
						String componnentCode=request.getParameter("componnentCode");
						String manufacturer=request.getParameter("manufacturer");
						String price=request.getParameter("price");
						String produceArea=request.getParameter("produceArea");
						String num=request.getParameter("num");
						if(as.AddPartImpl(componnentCode, num, price, manufacturer, produceArea)){
							request.setAttribute("message", "添加零件成功!");
							request.getRequestDispatcher("/addComponent.jsp").forward(request, response);
						}else{
							request.setAttribute("message", "添加零件失败!");
							request.getRequestDispatcher("/addComponent.jsp").forward(request, response);
						}
					}else if(type.equals("Search")){
						List<Part> rs=vs.ViewAllPartInfoImpl();
						request.setAttribute("info", rs);
						request.getRequestDispatcher("/checkComponent.jsp").forward(request, response);
					}else if(type.equals("Delete")){
						DeleteSomethingService ds=new DeleteSomethingService();
						String[] partIds=request.getParameterValues("delete");
						if(partIds!=null){
							for(String a:partIds){
								if(ds.DeletePartImpl(a)){
									continue;
								}else{
									break;
								}
							}
						}
						request.getRequestDispatcher("/ManagePart?type=Search").forward(request, response);
					}else if(type.equals("CreateModify")){//Modify
						String PartModel=request.getParameter("PartModel");
						Part rs=vs.ViewOnePartInfoImpl(PartModel);
						request.setAttribute("info", rs);
						request.getRequestDispatcher("/modifyNum.jsp").forward(request, response);
					}else{//Modify
						String PartModel=request.getParameter("PartModel");
						String AddNum=request.getParameter("AddNum");
						if(as.AddPartImpl(PartModel, AddNum)){
							request.getRequestDispatcher("/ManagePart?type=Search").forward(request, response);
						}else{
							request.setAttribute("message", "数量添加失败!");
							request.getRequestDispatcher("/ManagePart?type=CreateModify").forward(request, response);
						}
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
