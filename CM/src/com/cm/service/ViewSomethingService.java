package com.cm.service;

import java.util.List;

import com.cm.dao.ViewBillDao;
import com.cm.dao.ViewDao;
import com.cm.entity.Bill;
import com.cm.entity.CarInfo;
import com.cm.entity.ClientInfo;
import com.cm.entity.Part;
import com.cm.entity.ServicemanInfo;
import com.cm.entity.ServicemanInfoToBill;

public class ViewSomethingService extends BaseService{
	ViewBillDao view=new ViewBillDao();
	public List<Object[]> ViewBillImpl(String ClientId,int state){//查看某个状态所有的流水单    
		return view.ViewAllBillByDate(ClientId, state);
	}
	public List<Object[]> ViewOneBillImpl(String ClientId){//查看所有的流水单    
		return view.ViewAllBillByDate(ClientId);
	}
	public List<Object[]> ViewBillImpl(int state){//查看个人信息
		return view.ViewAllBillByDate(state);
	}
	public List<Object[]> ViewAllBillImpl(){//查看所有的流水单 
		return view.ViewAllBillByDate();
	}
	public List<Object[]> ViewAllServiceBillImpl(String ServiceId,int state ){//查看所有的流水单 
		return view.ViewServiceManBillByDate(ServiceId, state);
	}
	public List<Object[]> ViewBillDetailPartImpl(String BillNumber){//查看流水单零件
		try{
			return view.BillDetailPart(Integer.valueOf(BillNumber));
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public List<Object[]> ViewBillDetailServiceImpl(String BillNumber){//查看所有的维修员
		try{
			return view.BillDetailServiceMan(Integer.valueOf(BillNumber));
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public Bill ViewBillInfoImpl(String BillNumber){
		Bill bill=new Bill();
		System.out.println(BillNumber);
		bill.setBillNumber(Integer.valueOf(BillNumber));
		List<Bill> rs=Research(bill);
		if(rs.size()==1){
			return rs.get(0);
		}else return null;
	}
	public ClientInfo ViewClientInfoImpl(String ClientId){
		ClientInfo client=new ClientInfo();
		client.setClientId(ClientId);
		List<ClientInfo> rs=Research(client);
		if(rs.size()==1){
			return rs.get(0);
		}else return null;
	}
	public ServicemanInfo ViewServiceManInfoImpl(String ServiceManId){
		ServicemanInfo serviceMan=new ServicemanInfo();
		serviceMan.setServicemanId(ServiceManId);
		List<ServicemanInfo> rs=Research(serviceMan);
		if(rs.size()==1){
			return rs.get(0);
		}else return null;
	}
	public List<CarInfo> ViewAllCarInfoImpl(String ClientId){
		ViewDao vd=new ViewDao();
		return vd.ViewAllCarInfo(ClientId);
	}
	public List<CarInfo> ViewUnServiceCarInfoImpl(String ClientId){
		ViewDao vd=new ViewDao();
		return vd.ViewUnServiceCarInfo(ClientId);
	}
	public List<Part> ViewAllPartInfoImpl(){
		ViewDao vd=new ViewDao();
		return vd.ViewAllPartInfo();
	}
	public List<ServicemanInfo> ViewAllServiceManImpl(){
		ServicemanInfo vd=new ServicemanInfo();
		List<ServicemanInfo> rs=Research(vd);
		return rs;
	}
	public Part ViewOnePartInfoImpl(String PartModel){
		Part p=new Part();
		p.setPartModel(PartModel);
		List<Part> rs=Research(p);
		if(rs.size()==1){
			return rs.get(0);
		}
		else return null;
	}
	public CarInfo ViewOneCarInfoImpl(String CarId){
		CarInfo p=new CarInfo();
		p.setCarId(Integer.valueOf(CarId));
		List<CarInfo> rs=Research(p);
		if(rs.size()==1){
			return rs.get(0);
		}
		else return null;
	}
	public Float ViewBillManCostImpl(String ServiceManId,String BillId){
		ServicemanInfoToBill p=new ServicemanInfoToBill();
		p.setBillNumber(Integer.valueOf(BillId));
		p.setServicemanId(ServiceManId);
		List<ServicemanInfoToBill> rs=Research(p);
		if(rs.size()==1){
			return rs.get(0).getServiceCost();
		}
		else return null;
	}
}
