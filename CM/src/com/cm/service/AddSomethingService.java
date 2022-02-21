package com.cm.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.cm.entity.Bill;
import com.cm.entity.BillToPart;
import com.cm.entity.CarInfo;
import com.cm.entity.Part;
import com.cm.entity.ServicemanInfoToBill;

public class AddSomethingService extends BaseService{
	IsExistService Exist=new IsExistService();
	//增加零件库存
	public boolean AddPartImpl(String Model,String Number){//原来已有的型号 直接更新数量
		Part old=new Part();
		old.setPartModel(Model);
		List<Part> rs=Research(old);
		if(rs.size()==1){
			old.setPartNumber(Integer.valueOf(Number)+rs.get(0).getPartNumber());
			Revise(old);
			return true;
		}else return false;
	}
	public boolean AddPartImpl(String Model,String Number,String Price,String Vender,String ProduceArea){//原来没有的型号
		try{
			Part flash=new Part();
			flash.setPartModel(Model);
			flash.setPartNumber(Integer.valueOf(Number));
			flash.setPartPrice(Float.valueOf(Price));
			flash.setPartProduceArea(ProduceArea);
			flash.setPartVender(Vender);
			Add(flash);
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	//增加车辆
	public boolean AddCarImpl(String ClientId,String Code,String Model,String Area,String date,String Brand){
		try{
			CarInfo car=new CarInfo();
			car.setClientId(ClientId);
			car.setCarModel(Model);
			car.setCarDate(Date.valueOf(date));
			car.setCarCode(Code);
			car.setCarBrand(Brand);
			car.setCarArea(Area);
			Add(car);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	//维修  就是增加流水单
	public boolean AddBillImpl(String CarId,String Problem){
		try{
			Calendar c = Calendar.getInstance();// 获得系统当前日期
			Date date=new Date(c.getTimeInMillis());
			Bill bill=new Bill();
			bill.setCarId(Integer.valueOf(CarId));
			bill.setBillState(-1);//-1已经报修 但是还未开始维修  0正在维修  1维修完成
			bill.setBillServiceCost(0.0f);
			bill.setBillPartCost(0.0f);
			bill.setBillInspector(null);
			bill.setBillDate(date);
			bill.setProblem(Problem);
			Add(bill);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	//增加零件 对于维修而言
	public boolean AddBillPartImpl(String BillNumber,String PartModel,String Number){
		try{
			BillToPart bp=new BillToPart();
			Bill bill=new Bill();
			Part p=new Part();
			bp.setBillNumber(Integer.valueOf(BillNumber));
			bp.setPartModel(PartModel);
			if(Exist.BillIsExistImpl(Integer.valueOf(BillNumber))&&Exist.PartIdIsExistImpl(PartModel)){
				p.setPartModel(PartModel);
				List<Part> prs=Research(p);
				if(prs.get(0).getPartNumber()>Integer.valueOf(Number)){
					if(Exist.BillPartIsExistImpl(PartModel,Integer.valueOf(BillNumber))){//存在
						List<BillToPart> bprs=Research(bp);
						bp.setNumber(Integer.valueOf(Number)+bprs.get(0).getNumber());
						Revise(bp);
					}else{//不存在
						System.out.println(BillNumber+" "+PartModel);
						System.out.println("erroe!!!!!!");
						bp.setNumber(Integer.valueOf(Number));
						Add(bp);
					}
					bill.setBillNumber(Integer.valueOf(BillNumber));
					List<Bill> brs=Research(bill);
					bill.setBillPartCost(brs.get(0).getBillPartCost()+prs.get(0).getPartPrice()*Integer.valueOf(Number));
					p.setPartNumber(prs.get(0).getPartNumber()-Integer.valueOf(Number));
					Revise(bill);
					Revise(p);
					return true;
				}
				else return false;//数量不够
			}else return false;//流水单不存在
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	//增加维修人员 对于维修而言
	public boolean AddBillManImpl(String BillNumber,String ServicemanId,String ServiceCost){
		try{
			if(Exist.BillManIsExistImpl(Integer.valueOf(BillNumber), ServicemanId)) return false;
			else{
				ServicemanInfoToBill a=new ServicemanInfoToBill();
				a.setBillNumber(Integer.valueOf(BillNumber));
				a.setServicemanId(ServicemanId);
				a.setServiceCost(Float.valueOf(ServiceCost));
				Bill bill=new Bill();
				bill.setBillNumber(Integer.valueOf(BillNumber));
				List<Bill> rs=Research(bill);
				bill.setBillServiceCost(Float.valueOf(ServiceCost)+rs.get(0).getBillServiceCost());
				Revise(bill);
				Add(a);
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
