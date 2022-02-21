package com.cm.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cm.entity.CarInfo;
import com.cm.entity.Part;
import com.cm.util.DBHelper;

public class ViewDao {
	DBHelper DB=new DBHelper();
	public List<CarInfo> ViewAllCarInfo(String ClientId){
		try {
			String sql="select CarInfo.CarId,CarInfo.CarBrand,CarInfo.CarModel,CarInfo.CarCode," +
					"CarInfo.CarArea,CarInfo.CarDate from CarInfo where CarInfo.ClientId=? " +
					"order by CarInfo.CarId Desc";
			Object[] values=new Object[1];
			values[0]=ClientId;
			ResultSet rs=DB.executeQuery(sql, values);
			List<CarInfo> result=new ArrayList<CarInfo>();
			while(rs.next()){
				CarInfo a=new CarInfo();
				a.setCarId(rs.getInt("CarId"));
				a.setCarBrand(rs.getString("CarBrand"));
				a.setCarModel(rs.getString("CarModel"));
				a.setCarCode(rs.getString("CarCode"));
				a.setCarArea(rs.getString("CarArea"));
				a.setCarDate(rs.getDate("CarDate"));
				result.add(a);
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<CarInfo> ViewUnServiceCarInfo(String ClientId){
		try {
			String sql="select CarInfo.CarId,CarInfo.CarBrand,CarInfo.CarModel,CarInfo.CarCode," +
					"CarInfo.CarArea,CarInfo.CarDate from CarInfo where CarInfo.ClientId=? " +
					"and CarInfo.CarId not in(select Bill.CarId from Bill where Bill.BillState!=1) " +
					"order by CarInfo.CarId Desc";//找出所有没有未完成订单的车用以维修
			Object[] values=new Object[1];
			values[0]=ClientId;
			ResultSet rs=DB.executeQuery(sql, values);
			List<CarInfo> result=new ArrayList<CarInfo>();
			while(rs.next()){
				CarInfo a=new CarInfo();
				a.setCarId(rs.getInt("CarId"));
				a.setCarBrand(rs.getString("CarBrand"));
				a.setCarModel(rs.getString("CarModel"));
				a.setCarCode(rs.getString("CarCode"));
				a.setCarArea(rs.getString("CarArea"));
				a.setCarDate(rs.getDate("CarDate"));
				result.add(a);
			}
			//System.out.println(result.size());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Part> ViewAllPartInfo(){
		try {
			String sql="select * from Part order by PartNumber ASC";
			ResultSet rs=DB.executeQuery(sql, null);
			List<Part> result=new ArrayList<Part>();
			while(rs.next()){
				Part a=new Part();
				a.setPartModel(rs.getString("PartModel"));
				a.setPartNumber(rs.getInt("PartNumber"));
				a.setPartPrice(rs.getFloat("PartPrice"));
				a.setPartVender(rs.getString("PartVender"));
				a.setPartProduceArea(rs.getString("PartProduceArea"));
				result.add(a);
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public boolean CarNotInBill(int Id){//true shi not in
		try {
			String sql="select * from Bill where Bill.CarId=? and Bill.BillState!=1";
			Object[] values=new Object[1];
			values[0]=Id;
			ResultSet rs=DB.executeQuery(sql, values);
			if(rs.next()){
				return false;
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
