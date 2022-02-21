package com.cm.service;

import java.sql.Date;
import java.util.Calendar;

import com.cm.entity.ClientInfo;
import com.cm.entity.ServicemanInfo;

public class RegisterService extends BaseService{
	IsExistService Exist=new IsExistService();
	public int ClientRegisterImpl(String Id,String Name,String Password,String Sex,String Tel,String Code,String Phone){
		try {
			if(Exist.ClientIdIsExistImpl(Id)){
				return -1;//注册失败 
			}else{
				if(!Exist.ClientCodeIsExistImpl(Code)){
					Calendar c = Calendar.getInstance();// 获得系统当前日期
					Date date=new Date(c.getTimeInMillis());
					ClientInfo a=new ClientInfo();
					a.setClientId(Id);
					a.setClientCode(Code);
					a.setClientName(Name);
					a.setClientPassword(Password);
					a.setClientPhone(Phone);
					a.setClientSex(Boolean.valueOf(Sex));
					a.setClientTel(Tel);
					a.setClientRegisterTime(date);
					Add(a);
					return 1;
				}else return -2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	public int ServicemanRegisterImpl(String Id,String Name,String Password,String Sex,String Tel,String Code,String Attr){
		try {
			if(Exist.ServicemanIdIsExistImpl(Id)){
				return -1;
			}else{
				if(!Exist.ServicemanCodeIsExistImpl(Code)){
					ServicemanInfo a=new ServicemanInfo();
					a.setServicemanAttr(Attr);
					a.setServicemanCode(Code);
					a.setServicemanId(Id);
					a.setServicemanName(Name);
					a.setServicemanPassword(Password);
					a.setServicemanSex(Boolean.valueOf(Sex));
					a.setServicemanTel(Tel);
					Add(a);
					return 1;
				}else return -2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
