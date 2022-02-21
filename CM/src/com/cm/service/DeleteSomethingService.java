package com.cm.service;

import com.cm.entity.BillToPart;
import com.cm.entity.CarInfo;
import com.cm.entity.Part;
import com.cm.entity.ServicemanInfoToBill;

public class DeleteSomethingService extends BaseService{
	IsExistService Exist=new IsExistService();
	//删除车辆
	public boolean DeleteCarImpl(String Id){
		try{
			if(Exist.CarIsExistImpl(Integer.valueOf(Id))&&Exist.CarNotInBillImpl(Integer.valueOf(Id))){
				CarInfo a=new CarInfo();
				a.setCarId(Integer.valueOf(Id));
				Delete(a);
				return true;
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean DeletePartImpl(String Model){
		try{
			if(Exist.PartIdIsExistImpl(Model)){
				Part p=new Part();
				p.setPartModel(Model);
				Delete(p);
				return true;
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean DeleteBillPartImpl(String BillNumber,String PartModel){
		try{
			if(Exist.BillPartIsExistImpl(PartModel, Integer.valueOf(BillNumber))){
				BillToPart a=new BillToPart();
				a.setBillNumber(Integer.valueOf(BillNumber));
				a.setPartModel(PartModel);
				Delete(a);
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean DeleteBillManImpl(String BillNumber,String ServicemanId){
		try{
			if(Exist.BillManIsExistImpl(Integer.valueOf(BillNumber), ServicemanId)){
				ServicemanInfoToBill a=new ServicemanInfoToBill();
				a.setBillNumber(Integer.valueOf(BillNumber));
				a.setServicemanId(ServicemanId);
				Delete(a);
				return true;
			}else return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
