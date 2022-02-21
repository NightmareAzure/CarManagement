package com.cm.service;

import java.util.List;

import com.cm.entity.ClientInfo;
import com.cm.entity.ServicemanInfo;

public class LoginService extends BaseService{
	public boolean LoginImpl(String Id,String Password,String Type){
		try {
			if(Type.equals("Client")){
				ClientInfo a=new ClientInfo();
				a.setClientId(Id);
				a.setClientPassword(Password);
				List<ClientInfo> rs=Research(a);
				if(rs.size()==1) return true;
				else return false;
			}else if(Type.equals("ServiceMan")){
				ServicemanInfo a=new ServicemanInfo();
				a.setServicemanId(Id);
				a.setServicemanPassword(Password);
				List<ServicemanInfo> rs=Research(a);
				if(rs.size()==1) return true;
				else return false;
			}else return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}	
