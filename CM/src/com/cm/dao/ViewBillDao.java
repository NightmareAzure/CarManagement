package com.cm.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cm.util.DBHelper;

public class ViewBillDao {
	DBHelper DB=new DBHelper();
	public List<Object[]> ViewAllBillByDate(String ClientId,int state){//-1 0 1
		try {
			String sql="select Bill.BillNumber,Bill.BillPartCost,Bill.BillServiceCost," +
					"Bill.BillDate,Bill.BillInspector,Bill.BillState,Bill.Problem," +
					"CarInfo.CarModel,CarInfo.CarBrand,CarInfo.CarCode " +
					"from Bill,CarInfo,ClientInfo where ClientInfo.ClientId=? and " +
					"ClientInfo.ClientId=CarInfo.ClientId and CarInfo.CarId=Bill.CarId "+
					"and Bill.BillState=? order by Bill.BillDate ASC,Bill.BillState ASC";
			Object[] values=new Object[2];
			values[0]=ClientId;
			values[1]=state;
			ResultSet rs=DB.executeQuery(sql, values);
			List<Object[]> result=new ArrayList<Object[]>();
			while(rs.next()){
				Object[] a=new Object[10];
				a[0]=rs.getInt("BillNumber");
				a[1]=rs.getString("CarCode");
				a[2]=rs.getString("CarModel");
				a[3]=rs.getString("CarBrand");
				a[4]=rs.getDate("BillDate");
				a[5]=rs.getString("BillInspector");
				a[6]=rs.getFloat("BillPartCost");
				a[7]=rs.getFloat("BillServiceCost");
				a[8]=rs.getInt("BillState");
				a[9]=rs.getString("Problem");
				result.add(a);
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Object[]> ViewAllBillByDate(int state){
		try {
			String sql="select Bill.BillNumber,Bill.BillPartCost,Bill.BillServiceCost," +
					"Bill.BillDate,Bill.BillInspector,Bill.BillState,Bill.Problem," +
					"CarInfo.CarModel,CarInfo.CarBrand,CarInfo.CarCode,ClientInfo.ClientName," +
					"ClientInfo.ClientTel,ClientInfo.ClientPhone from Bill,CarInfo,ClientInfo " +
					"where ClientInfo.ClientId=CarInfo.ClientId and CarInfo.CarId=Bill.CarId "+
					"and Bill.BillState=? order by Bill.BillDate ASC,Bill.BillState ASC";
			Object[] values=new Object[1];
			values[0]=state;
			ResultSet rs=DB.executeQuery(sql, values);
			List<Object[]> result=new ArrayList<Object[]>();
			while(rs.next()){
				Object[] a=new Object[13];
				a[0]=rs.getInt("BillNumber");
				a[1]=rs.getString("ClientName");
				a[2]=rs.getString("ClientTel");
				a[3]=rs.getString("ClientPhone");
				a[4]=rs.getString("CarCode");
				a[5]=rs.getString("CarModel");
				a[6]=rs.getString("CarBrand");
				a[7]=rs.getDate("BillDate");
				a[8]=rs.getString("BillInspector");
				a[9]=rs.getFloat("BillPartCost");
				a[10]=rs.getFloat("BillServiceCost");
				a[11]=rs.getInt("BillState");
				a[12]=rs.getString("Problem");
				result.add(a);
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Object[]> ViewAllBillByDate(String ClientId){
		try {
			String sql="select Bill.BillNumber,Bill.BillPartCost,Bill.BillServiceCost," +
					"Bill.BillDate,Bill.BillInspector,Bill.BillState,Bill.Problem," +
					"CarInfo.CarModel,CarInfo.CarBrand,CarInfo.CarCode " +
					"from Bill,CarInfo,ClientInfo where ClientInfo.ClientId=? and " +
					"ClientInfo.ClientId=CarInfo.ClientId and CarInfo.CarId=Bill.CarId" +
					" order by Bill.BillDate ASC,Bill.BillState ASC";
			Object[] values=new Object[1];
			values[0]=ClientId;
			ResultSet rs=DB.executeQuery(sql, values);
			List<Object[]> result=new ArrayList<Object[]>();
			while(rs.next()){
				Object[] a=new Object[10];
				a[0]=rs.getInt("BillNumber");
				a[1]=rs.getString("CarCode");
				a[2]=rs.getString("CarModel");
				a[3]=rs.getString("CarBrand");
				a[4]=rs.getDate("BillDate");
				a[5]=rs.getString("BillInspector");
				a[6]=rs.getFloat("BillPartCost");
				a[7]=rs.getFloat("BillServiceCost");
				a[8]=rs.getInt("BillState");
				a[9]=rs.getString("Problem");
				result.add(a);
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Object[]> ViewAllBillByDate(){//维修员查看所有流水单(按时间排序的)  还需要车主信息
		try {
			String sql="select Bill.BillNumber,Bill.BillPartCost,Bill.BillServiceCost," +
					"Bill.BillDate,Bill.BillInspector,Bill.BillState,Bill.Problem," +
					"CarInfo.CarModel,CarInfo.CarBrand,CarInfo.CarCode,ClientInfo.ClientName," +
					"ClientInfo.ClientTel,ClientInfo.ClientPhone from Bill,CarInfo,ClientInfo " +
					"where ClientInfo.ClientId=CarInfo.ClientId and CarInfo.CarId=Bill.CarId" +
					" order by Bill.BillDate ASC,Bill.BillState ASC";
			ResultSet rs=DB.executeQuery(sql, null);
			List<Object[]> result=new ArrayList<Object[]>();
			while(rs.next()){
				Object[] a=new Object[13];
				a[0]=rs.getInt("BillNumber");
				a[1]=rs.getString("ClientName");
				a[2]=rs.getString("ClientTel");
				a[3]=rs.getString("ClientPhone");
				a[4]=rs.getString("CarCode");
				a[5]=rs.getString("CarModel");
				a[6]=rs.getString("CarBrand");
				a[7]=rs.getDate("BillDate");
				a[8]=rs.getString("BillInspector");
				a[9]=rs.getFloat("BillPartCost");
				a[10]=rs.getFloat("BillServiceCost");
				a[11]=rs.getInt("BillState");
				a[12]=rs.getString("Problem");
				result.add(a);
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Object[]> ViewServiceManBillByDate(String serviceManId,int state){//维修员查看所有流水单(按时间排序的)  还需要车主信息
		try {
			String sql="select Bill.BillNumber,Bill.BillPartCost,Bill.BillServiceCost,Bill.BillDate," +
					"Bill.BillInspector,Bill.BillState,Bill.Problem,CarInfo.CarModel,CarInfo.CarBrand," +
					"CarInfo.CarCode,ClientInfo.ClientName,ClientInfo.ClientTel,ClientInfo.ClientPhone " +
					"from Bill,CarInfo,ClientInfo,ServicemanInfoToBill where ServicemanInfoToBill.BillNumber=Bill.BillNumber and " +
					"ServicemanInfoToBill.ServicemanId=? and Bill.CarId=CarInfo.CarId " +
					"and ClientInfo.ClientId=CarInfo.ClientId and Bill.BillState=?" +
					" order by Bill.BillDate ASC,Bill.BillState ASC";
			Object[] values=new Object[2];
			values[0]=serviceManId;
			values[1]=state;
			ResultSet rs=DB.executeQuery(sql, values);
			List<Object[]> result=new ArrayList<Object[]>();
			while(rs.next()){
				Object[] a=new Object[13];
				a[0]=rs.getInt("BillNumber");
				a[1]=rs.getString("ClientName");
				a[2]=rs.getString("ClientTel");
				a[3]=rs.getString("ClientPhone");
				a[4]=rs.getString("CarCode");
				a[5]=rs.getString("CarModel");
				a[6]=rs.getString("CarBrand");
				a[7]=rs.getDate("BillDate");
				a[8]=rs.getString("BillInspector");
				a[9]=rs.getFloat("BillPartCost");
				a[10]=rs.getFloat("BillServiceCost");
				a[11]=rs.getInt("BillState");
				a[12]=rs.getString("Problem");
				result.add(a);
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Object[]> BillDetailPart (int BillNumber){
		try{
			String sql="select BillToPart.PartModel,BillToPart.Number,Part.PartPrice " +
					"from BillToPart,Part where BillToPart.BillNumber=? and " +
					"Part.PartModel=BillToPart.PartModel";
			Object[] values=new Object[1];
			values[0]=BillNumber;
			ResultSet rs=DB.executeQuery(sql, values);
			List<Object[]> result=new ArrayList<Object[]>();
			while(rs.next()){
				Object[] a=new Object[4];
				a[0]=rs.getString("PartModel");
				a[1]=rs.getInt("Number");
				a[2]=rs.getFloat("PartPrice");
				a[3]=rs.getInt("Number")*rs.getFloat("PartPrice");
				result.add(a);
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public List<Object[]> BillDetailServiceMan (int BillNumber){
		try{
			String sql="select ServicemanInfoToBill.ServicemanId,ServicemanInfo.ServicemanName," +
					"ServicemanInfoToBill.ServiceCost from ServicemanInfo,ServicemanInfoToBill " +
					"where ServicemanInfo.ServicemanId=ServicemanInfoToBill.ServicemanId and " +
					"ServicemanInfoToBill.BillNumber=?";
			Object[] values=new Object[1];
			values[0]=BillNumber;
			ResultSet rs=DB.executeQuery(sql, values);
			List<Object[]> result=new ArrayList<Object[]>();
			while(rs.next()){
				Object[] a=new Object[3];
				a[0]=rs.getString("ServicemanId");
				a[1]=rs.getString("ServicemanName");
				a[2]=rs.getFloat("ServiceCost");
				result.add(a);
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
