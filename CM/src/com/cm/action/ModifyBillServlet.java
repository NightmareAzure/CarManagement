package com.cm.action;
//维修提交问题那里有问题    这里还有添加未完成
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cm.core.CMError;
import com.cm.entity.Bill;
import com.cm.entity.Part;
import com.cm.entity.ServicemanInfo;
import com.cm.service.AddSomethingService;
import com.cm.service.ChangeSomethingService;
import com.cm.service.DeleteSomethingService;
import com.cm.service.ViewSomethingService;

public class ModifyBillServlet extends HttpServlet {

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
			ChangeSomethingService cs=new ChangeSomethingService();
			if(form.equals("ServiceMan")){
				if(type.equals("CreateBillModify")){//ok
					String BillId=request.getParameter("BillId");
					Bill bill=vs.ViewBillInfoImpl(BillId);
					List<Object[]> part=vs.ViewBillDetailPartImpl(BillId);
					List<Object[]> Service=vs.ViewBillDetailServiceImpl(BillId);
					List<Part> Allpart=vs.ViewAllPartInfoImpl();
					List<ServicemanInfo> AllService=vs.ViewAllServiceManImpl();
					request.setAttribute("bill", bill);
					request.setAttribute("part", part);
					request.setAttribute("Service", Service);
					request.setAttribute("AllService", AllService);
					request.setAttribute("Allpart", Allpart);
					request.setAttribute("BillId", BillId);
					request.getRequestDispatcher("/Supdate.jsp").forward(request, response);
				}else if(type.equals("CreatePartModify")){//ok
					String partModel=request.getParameter("partModel");
					String partNum=request.getParameter("partNum");
					String BillId=request.getParameter("BillId");
					request.setAttribute("partModel", partModel);
					request.setAttribute("partNum", partNum);
					request.setAttribute("BillId", BillId);
					request.getRequestDispatcher("/modifyComponentNumber.jsp").forward(request, response);
				}else if(type.equals("CreateServiceModify")){//ok
					String BillId=request.getParameter("BillId");
					String ServiceManId=request.getParameter("ServiceManId");
					String ServiceManName=request.getParameter("ServiceManName");
					String ServiceCost=request.getParameter("ServiceCost");
					request.setAttribute("ServiceCost", ServiceCost);
					request.setAttribute("BillId", BillId);
					request.setAttribute("ServiceManId", ServiceManId);
					request.setAttribute("ServiceManName", ServiceManName);
					request.getRequestDispatcher("/modifyServiceMan.jsp").forward(request, response);
				}else if(type.equals("ModifyBill")){//ok
					String BillId=request.getParameter("BillId");
					String inspector=request.getParameter("inspector");
					String state=request.getParameter("state");
					//System.out.println(BillId+"!!!!"+state+"...."+inspector);
					request.setAttribute("BillId", BillId);
					if(cs.ChangeBillStateImpl(BillId,state)){
						//System.out.println("ok ChangeBillStateImpl");
						if(cs.ChangeBillCheckManImpl(BillId, inspector)){//修改inspector
							//System.out.println("ok ChangeBillCheckManImpl");
							request.setAttribute("message", "修改成功!");
							request.getRequestDispatcher("/error.jsp").forward(request, response);
						}else{
							request.setAttribute("message", "状态修改成功，检验员修改失败!");
							request.getRequestDispatcher("/error.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("message", "修改失败!");
						request.getRequestDispatcher("/error.jsp").forward(request, response);
					}
				}else if(type.equals("ModifyPartNumber")){//ok
					String BillId=request.getParameter("BillId");
					String partModel=request.getParameter("partModel");
					String partNum=request.getParameter("partNum");
					if(as.AddBillPartImpl(BillId, partModel, partNum)){
						request.getRequestDispatcher("/ModifyBill?type=CreateBillModify").forward(request, response);
					}else{
						request.setAttribute("message", "零件数量修改失败!");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
				}else if(type.equals("ModifyServiceCost")){//ok
					String BillId=request.getParameter("BillId");
					String ServiceManId=request.getParameter("ServiceManId");
					String ServiceCost=request.getParameter("ServiceCost");
					if(cs.ChangeBillServiceCostImpl(ServiceCost, BillId, ServiceManId)){
						request.getRequestDispatcher("/ModifyBill?type=CreateBillModify").forward(request, response);
					}else{
						request.setAttribute("message", "维修费用修改失败!");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
				}else if(type.equals("DeletePart")){//ok
					String BillId=request.getParameter("BillId");
					DeleteSomethingService ds=new DeleteSomethingService();
					String[] partIds=request.getParameterValues("deletePart");
					if(partIds!=null){
						for(String a:partIds){
							if(ds.DeleteBillPartImpl(BillId, a)){
								continue;
							}else{
								break;
							}
						}
					}
					request.getRequestDispatcher("/ModifyBill?type=CreateBillModify").forward(request, response);
				}else if(type.equals("DeleteServiceMan")){//ok
					String BillId=request.getParameter("BillId");
					DeleteSomethingService ds=new DeleteSomethingService();
					String[] ServiceManIds=request.getParameterValues("deleteServiceMan");
					if(ServiceManIds!=null){
						for(String a:ServiceManIds){
							if(ds.DeleteBillManImpl(BillId, a)){
								continue;
							}else{
								break;
							}
						}
					}
					request.getRequestDispatcher("/ModifyBill?type=CreateBillModify").forward(request, response);
				}else if(type.equals("AddServiceMan")){
					String[] addServiceManId=request.getParameterValues("addServiceMan");
					String[] price=request.getParameterValues("price");
					String BillId=request.getParameter("BillId");
					request.setAttribute("BillId", BillId);
					int flag=1;
					if(addServiceManId!=null&&price!=null){
						for(int i=0,j=0;i<addServiceManId.length;i++,j++){
							while(price[j].equals("输入..")){
								j++;
							}
							if(as.AddBillManImpl(BillId, addServiceManId[i], price[j])){
								continue;
							}else{
								flag=0;
								break;
							}
						}
						if(flag==1){
							request.setAttribute("message", "添加维修员成功!");
						}else{
							request.setAttribute("message", "添加部分维修员成功!");
						}
					}else{
						request.setAttribute("message", "添加维修员失败!");
					}
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}else{//AddPart
					String[] addPartModels=request.getParameterValues("addPart");
					String[] number=request.getParameterValues("number");
					String BillId=request.getParameter("BillId");
					request.setAttribute("BillId", BillId);
					int flag=1;
					if(addPartModels!=null&&number!=null){
						for(int i=0,j=0;i<addPartModels.length;i++,j++){
							while(number[j].equals("0")){
								j++;
							}
							if(as.AddBillPartImpl(BillId, addPartModels[i], number[j])){
								continue;
							}else{
								flag=0;
								break;
							}
						}
						if(flag==1){
							request.setAttribute("message", "添加零件成功!");
						}else{
							request.setAttribute("message", "添加部分零件成功!");
						}
					}else{
						request.setAttribute("message", "添加零件失败!");
					}
					request.getRequestDispatcher("error.jsp").forward(request, response);
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
			//String username=request.getSession().getAttribute("username").toString();
			String form=request.getSession().getAttribute("form").toString();
			String type=request.getParameter("type");
			request.getSession().setAttribute("msg", "");
			ViewSomethingService vs=new ViewSomethingService();
			AddSomethingService as=new AddSomethingService();
			ChangeSomethingService cs=new ChangeSomethingService();
			if(form.equals("ServiceMan")){
				if(type.equals("CreateBillModify")){//ok
					String BillId=request.getParameter("BillId");
					Bill bill=vs.ViewBillInfoImpl(BillId);
					List<Object[]> part=vs.ViewBillDetailPartImpl(BillId);
					List<Object[]> Service=vs.ViewBillDetailServiceImpl(BillId);
					List<Part> Allpart=vs.ViewAllPartInfoImpl();
					List<ServicemanInfo> AllService=vs.ViewAllServiceManImpl();
					request.setAttribute("bill", bill);
					request.setAttribute("part", part);
					request.setAttribute("Service", Service);
					request.setAttribute("AllService", AllService);
					request.setAttribute("Allpart", Allpart);
					request.setAttribute("BillId", BillId);
					request.getRequestDispatcher("/Supdate.jsp").forward(request, response);
				}else if(type.equals("CreatePartModify")){//ok
					String partModel=request.getParameter("partModel");
					String partNum=request.getParameter("partNum");
					String BillId=request.getParameter("BillId");
					request.setAttribute("partModel", partModel);
					request.setAttribute("partNum", partNum);
					request.setAttribute("BillId", BillId);
					request.getRequestDispatcher("/modifyComponentNumber.jsp").forward(request, response);
				}else if(type.equals("CreateServiceModify")){//ok
					String BillId=request.getParameter("BillId");
					String ServiceManId=request.getParameter("ServiceManId");
					String ServiceManName=request.getParameter("ServiceManName");
					String ServiceCost=request.getParameter("ServiceCost");
					request.setAttribute("ServiceCost", ServiceCost);
					request.setAttribute("BillId", BillId);
					request.setAttribute("ServiceManId", ServiceManId);
					request.setAttribute("ServiceManName", ServiceManName);
					request.getRequestDispatcher("/modifyServiceMan.jsp").forward(request, response);
				}else if(type.equals("ModifyBill")){//ok
					String BillId=request.getParameter("BillId");
					String inspector=request.getParameter("inspector");
					String state=request.getParameter("state");
					//System.out.println(BillId+"!!!!"+state+"...."+inspector);
					request.setAttribute("BillId", BillId);
					if(cs.ChangeBillStateImpl(BillId,state)){
						//System.out.println("ok ChangeBillStateImpl");
						if(cs.ChangeBillCheckManImpl(BillId, inspector)){//修改inspector
							//System.out.println("ok ChangeBillCheckManImpl");
							request.setAttribute("message", "修改成功!");
							request.getRequestDispatcher("/error.jsp").forward(request, response);
						}else{
							request.setAttribute("message", "状态修改成功，检验员修改失败!");
							request.getRequestDispatcher("/error.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("message", "修改失败!");
						request.getRequestDispatcher("/error.jsp").forward(request, response);
					}
				}else if(type.equals("ModifyPartNumber")){//ok
					String BillId=request.getParameter("BillId");
					String partModel=request.getParameter("partModel");
					String partNum=request.getParameter("partNum");
					if(as.AddBillPartImpl(BillId, partModel, partNum)){
						request.getRequestDispatcher("/ModifyBill?type=CreateBillModify").forward(request, response);
					}else{
						request.setAttribute("message", "零件数量修改失败!");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
				}else if(type.equals("ModifyServiceCost")){//ok
					String BillId=request.getParameter("BillId");
					String ServiceManId=request.getParameter("ServiceManId");
					String ServiceCost=request.getParameter("ServiceCost");
					if(cs.ChangeBillServiceCostImpl(ServiceCost, BillId, ServiceManId)){
						request.getRequestDispatcher("/ModifyBill?type=CreateBillModify").forward(request, response);
					}else{
						request.setAttribute("message", "维修费用修改失败!");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
				}else if(type.equals("DeletePart")){//ok
					String BillId=request.getParameter("BillId");
					DeleteSomethingService ds=new DeleteSomethingService();
					String[] partIds=request.getParameterValues("deletePart");
					if(partIds!=null){
						for(String a:partIds){
							if(ds.DeleteBillPartImpl(BillId, a)){
								continue;
							}else{
								break;
							}
						}
					}
					request.getRequestDispatcher("/ModifyBill?type=CreateBillModify").forward(request, response);
				}else if(type.equals("DeleteServiceMan")){//ok
					String BillId=request.getParameter("BillId");
					DeleteSomethingService ds=new DeleteSomethingService();
					String[] ServiceManIds=request.getParameterValues("deleteServiceMan");
					if(ServiceManIds!=null){
						for(String a:ServiceManIds){
							if(ds.DeleteBillManImpl(BillId, a)){
								continue;
							}else{
								break;
							}
						}
					}
					request.getRequestDispatcher("/ModifyBill?type=CreateBillModify").forward(request, response);
				}else if(type.equals("AddServiceMan")){
					String[] addServiceManId=request.getParameterValues("addServiceMan");
					String[] price=request.getParameterValues("price");
					String BillId=request.getParameter("BillId");
					request.setAttribute("BillId", BillId);
					int flag=1;
					if(addServiceManId!=null&&price!=null){
						for(int i=0,j=0;i<addServiceManId.length;i++,j++){
							while(price[j].equals("输入..")){
								j++;
							}
							if(as.AddBillManImpl(BillId, addServiceManId[i], price[j])){
								continue;
							}else{
								flag=0;
								break;
							}
						}
						if(flag==1){
							request.setAttribute("message", "添加维修员成功!");
						}else{
							request.setAttribute("message", "添加部分维修员成功!");
						}
					}else{
						request.setAttribute("message", "添加维修员失败!");
					}
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}else{//AddPart
					String[] addPartModels=request.getParameterValues("addPart");
					String[] number=request.getParameterValues("number");
					String BillId=request.getParameter("BillId");
					request.setAttribute("BillId", BillId);
					int flag=1;
					if(addPartModels!=null&&number!=null){
						for(int i=0,j=0;i<addPartModels.length;i++,j++){
							while(number[j].equals("0")){
								j++;
							}
							if(as.AddBillPartImpl(BillId, addPartModels[i], number[j])){
								continue;
							}else{
								flag=0;
								break;
							}
						}
						if(flag==1){
							request.setAttribute("message", "添加零件成功!");
						}else{
							request.setAttribute("message", "添加部分零件成功!");
						}
					}else{
						request.setAttribute("message", "添加零件失败!");
					}
					request.getRequestDispatcher("error.jsp").forward(request, response);
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
