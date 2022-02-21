package com.cm.service;

import java.util.List;

import com.cm.dao.ViewDao;
import com.cm.entity.Bill;
import com.cm.entity.BillToPart;
import com.cm.entity.CarInfo;
import com.cm.entity.ClientInfo;
import com.cm.entity.Part;
import com.cm.entity.ServicemanInfo;
import com.cm.entity.ServicemanInfoToBill;

public class IsExistService extends BaseService{
	public boolean ClientIdIsExistImpl(String Id){
		ClientInfo a=new ClientInfo();
		a.setClientId(Id);
		List<ClientInfo> rs=Research(a);
		if(rs.size()==0) return false;//Id不存在
		else return true;//Id存在
	}
	public boolean ServicemanIdIsExistImpl(String Id){
		ServicemanInfo a=new ServicemanInfo();
		a.setServicemanId(Id);
		List<ServicemanInfo> rs=Research(a);
		if(rs.size()==0){
			return false;
		}else return true;
	}
	public boolean ClientCodeIsExistImpl(String Code){
		ClientInfo a=new ClientInfo();
		a.setClientCode(Code);
		List<ClientInfo> rs=Research(a);
		if(rs.size()==0){
			return false;
		}else return true;
	}
	public boolean ServicemanCodeIsExistImpl(String Code){
		ServicemanInfo a=new ServicemanInfo();
		a.setServicemanCode(Code);
		List<ServicemanInfo> rs=Research(a);
		if(rs.size()==0){
			return false;
		}else return true;
	}
	public boolean PartIdIsExistImpl(String Id){
		Part a=new Part();
		a.setPartModel(Id);
		List<Part> rs=Research(a);
		if(rs.size()==0) return false;
		else return true;
	}
	public boolean BillPartIsExistImpl(String PartModel,int BillNumber){
		BillToPart a=new BillToPart();
		a.setBillNumber(BillNumber);
		a.setPartModel(PartModel);
		System.out.println(PartModel+"!!!!!"+BillNumber);
		List<BillToPart> rs=Research(a);
		System.out.println(rs.size());
		if(rs.size()==1) return true;
		else return false;
	}
	public boolean BillManIsExistImpl(int BillNumber,String ServicemanId){
		ServicemanInfoToBill a=new ServicemanInfoToBill();
		a.setBillNumber(BillNumber);
		a.setServicemanId(ServicemanId);
		List<ServicemanInfoToBill> rs=Research(a);
		if(rs.size()==0) return false;
		else return true;
	}
	
	public boolean CarIsExistImpl(int Id){
		CarInfo a=new CarInfo();
		a.setCarId(Id);
		List<CarInfo> rs=Research(a);
		if(rs.size()==0) return false;
		else return true;
	}
	public boolean CarNotInBillImpl(int Id){//当车不在未完成的订单里时返回true  否则返回false
		ViewDao vd=new ViewDao();
		return vd.CarNotInBill(Id);
	}
	public boolean BillIsExistImpl(int billNumber){
		Bill a=new Bill();
		a.setBillNumber(billNumber);
		List<Bill> rs=Research(a);
		if(rs.size()==0) return false;
		else return true;
	}
}
