package com.cm.service;

import java.util.List;

import com.cm.entity.Bill;
import com.cm.entity.ClientInfo;
import com.cm.entity.ServicemanInfo;
import com.cm.entity.ServicemanInfoToBill;

public class ChangeSomethingService extends BaseService{//-1已经报修 但是还未开始维修  0正在维修  1维修完成
	IsExistService Exist=new IsExistService();
	public boolean ChangeBillServiceCostImpl(String BillServiceCost,String BillNumber,String ServiceManId){
		try{
			if(Exist.BillIsExistImpl(Integer.valueOf(BillNumber))){
				Bill bill=new Bill();
				bill.setBillNumber(Integer.valueOf(BillNumber));
				List<Bill> rs=Research(bill);
				ServicemanInfoToBill sbill=new ServicemanInfoToBill();
				sbill.setBillNumber(Integer.valueOf(BillNumber));
				sbill.setServiceCost(Float.valueOf(BillServiceCost));
				sbill.setServicemanId(ServiceManId);
				Revise(sbill);
				bill.setBillServiceCost(rs.get(0).getBillServiceCost()+Float.valueOf(BillServiceCost));
				Revise(bill);
				return true;
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean ChangeBillCheckManImpl(String BillNumber,String CheckMan){
		try{
			if(Exist.BillIsExistImpl(Integer.valueOf(BillNumber))){
				Bill bill=new Bill();
				bill.setBillNumber(Integer.valueOf(BillNumber));
				bill.setBillInspector(CheckMan);
				Revise(bill);
				return true;
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean ChangeBillStateImpl(String BillNumber,String state){
		try{
			if(Exist.BillIsExistImpl(Integer.valueOf(BillNumber))){
				Bill bill=new Bill();
				bill.setBillNumber(Integer.valueOf(BillNumber));
				bill.setBillState(Integer.valueOf(state));
				Revise(bill);
				return true;
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean ChangeBillStateCompleteImpl(String BillNumber){
		try{
			if(Exist.BillIsExistImpl(Integer.valueOf(BillNumber))){
				Bill bill=new Bill();
				bill.setBillNumber(Integer.valueOf(BillNumber));
				bill.setBillState(1);
				Revise(bill);
				return true;
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean ChangeClientPasswordImpl(String ClientId,String oldPd,String newPd){
		try{
			if(Exist.ClientIdIsExistImpl(ClientId)){
				ClientInfo client=new ClientInfo();
				client.setClientId(ClientId);
				List<ClientInfo> crs=Research(client);
				if(crs.get(0).getClientPassword().equals(oldPd)){
					client.setClientPassword(newPd);
					Revise(client);
					return true;
				}else{
					return false;
				}
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean ChangeClientTelImpl(String ClientId,String Tel){
		try{
			if(Exist.ClientIdIsExistImpl(ClientId)){
				ClientInfo client=new ClientInfo();
				client.setClientId(ClientId);
				client.setClientTel(Tel);
				Revise(client);
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean ChangeClientPhoneImpl(String ClientId,String phone){
		try{
			if(Exist.ClientIdIsExistImpl(ClientId)){
				ClientInfo client=new ClientInfo();
				client.setClientId(ClientId);
				client.setClientPhone(phone);
				Revise(client);
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean ChangeServicePasswordImpl(String ServicemanId,String oldPd,String newPd){
		try{
			if(Exist.ServicemanIdIsExistImpl(ServicemanId)){
				ServicemanInfo s=new ServicemanInfo();
				s.setServicemanId(ServicemanId);
				List<ServicemanInfo> srs=Research(s);
				if(srs.get(0).getServicemanPassword().equals(oldPd)){
					s.setServicemanPassword(newPd);
					Revise(s);
					return true;
				}else{
					return false;
				}
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean ChangeServiceTelImpl(String ServicemanId,String tel){
		try{
			if(Exist.ServicemanIdIsExistImpl(ServicemanId)){
				ServicemanInfo s=new ServicemanInfo();
				s.setServicemanId(ServicemanId);
				s.setServicemanTel(tel);
				Revise(s);
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
