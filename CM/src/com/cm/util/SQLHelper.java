package com.cm.util;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cm.core.ADD;
import com.cm.core.Id;
import com.cm.core.CMError;

public class SQLHelper {
	private DBHelper DB=new DBHelper();
	public void CreateAddSQL(Object value){
		String sql="insert into ";
		Class c = value.getClass();
		int ks=0;
		List<Object> val=new ArrayList<Object>();
		boolean flag=false;
		int i=0;
		sql=sql+c.getSimpleName()+'(';//getSimpleName取得类名
		try {
			for(Field f : c.getDeclaredFields()){//c.getDeclaredFields()得到c中所有的属性
				if(!f.isAnnotationPresent(Id.class)){//f.get(value)取得f域(即某个属性)的值
					if(flag==false){
						sql=sql+f.getName();
						flag=true;
						f.setAccessible(true);
						val.add(f.get(value));
					}
					else if(flag==true){
						sql=sql+','+f.getName();
						f.setAccessible(true);
						val.add(f.get(value));
					}
				}
				else ks++;
			}
		} catch (Exception e) {
			throw new CMError(e.getMessage(),e);
		}
		sql=sql+") values(?";
		for(i=1;i<c.getDeclaredFields().length-ks;i++){
			sql=sql+",?";
		}
		sql=sql+')';
		Object[] values=new Object[val.size()];
		for(i=0;i<val.size();i++)
			values[i]=val.get(i);//将参数包装成Object的数组传入
		System.out.println(sql);
		DB.executeUpdate(sql, values);
		DB.DBClose();
	}
	public void CreateDeleteSQL(Object value){
		String sql="delete from ";
		Class c = value.getClass();
		boolean flag=false;
		List<Object> val=new ArrayList<Object>();
		sql=sql+c.getSimpleName()+" where ";
		int i=0;
		try {
			for(Field f : c.getDeclaredFields()){
				f.setAccessible(true);
				if(f.get(value)!=null&&flag==false){
					sql=sql+f.getName()+"=?";
					f.setAccessible(true);
					val.add(f.get(value));
					flag=true;
				}
				else if(f.get(value)!=null&&flag==true){
					sql=sql+" AND "+f.getName()+"=?";
					val.add(f.get(value));
				}
			}
		} catch (Exception e) {
			throw new CMError(e.getMessage(),e);
		}
		System.out.println(sql);
		Object[] values=new Object[val.size()];
		for(;i<val.size();i++)
			values[i]=val.get(i);
		DB.executeUpdate(sql, values);
		DB.DBClose();
	}
	public void CreateReviseSQL(Object value){
		String sql="update ";
		boolean flag=false;
		Class c = value.getClass();
		List<Object> val=new ArrayList<Object>();
		sql=sql+c.getSimpleName()+" set ";
		int i=0;
		try {
			for(Field f : c.getDeclaredFields()){
				if(!f.isAnnotationPresent(Id.class)&&!f.isAnnotationPresent(ADD.class)){
					f.setAccessible(true);
					if(f.get(value)!=null&&flag==false){
						sql=sql+f.getName()+"=?";
						flag=true;
						val.add(f.get(value));
					}
					else if(f.get(value)!=null&&flag==true){
						sql=sql+','+f.getName()+"=?";
						val.add(f.get(value));
					}
				}
			}
			sql=sql+" where ";
			flag=false;
			for(Field f : c.getDeclaredFields()){
				f.setAccessible(true);
				if((f.isAnnotationPresent(ADD.class)||f.isAnnotationPresent(Id.class))&&f.get(value)!=null&&flag==false){
					sql=sql+f.getName()+"=?";
					flag=true;
					val.add(f.get(value));
				}
				else if((f.isAnnotationPresent(ADD.class)||f.isAnnotationPresent(Id.class))&&f.get(value)!=null&&flag==true){
					sql=sql+" AND "+f.getName()+"=?";
					val.add(f.get(value));
				}
			}
		} catch (Exception e) {
			throw new CMError(e.getMessage(),e);
		}
		System.out.println(sql);
		Object[] values=new Object[val.size()];
		for(i=0;i<val.size();i++)
			values[i]=val.get(i);
		DB.executeUpdate(sql, values);
		DB.DBClose();
	}//默认不允许修改主键
	public List CreateReserchSQL(Object value){
		String sql="select * from ";
		Class c = value.getClass();
		List<Object> rs=new ArrayList<Object>();
		List<Object> val=new ArrayList<Object>();
		int i=0;
		boolean flag=false;
		sql=sql+c.getSimpleName();
		try {
		for(Field f : c.getDeclaredFields()){
			f.setAccessible(true);
			if(f.get(value)!=null){
				sql=sql+" where ";
				break;
			}
		}
		for(Field f : c.getDeclaredFields()){
			f.setAccessible(true);
			if(f.get(value)!=null&&flag==false){
				sql=sql+f.getName()+"=?";
				flag=true;
				val.add(f.get(value));
			}
			else if(f.get(value)!=null&&flag==true){
				sql=sql+" AND "+f.getName()+"=?";
				f.setAccessible(true);
				val.add(f.get(value));
			}
		}
		Object[] values=new Object[val.size()];
		for(;i<val.size();i++){
			values[i]=val.get(i);
		}
		System.out.println(sql);
		ResultSet rss = DB.executeQuery(sql, values);
			while(rss.next()){
				Object o=c.newInstance();
				Object fol=null;
				for(Field f : c.getDeclaredFields()){
					if(f.getType()==String.class){
						fol=rss.getString(f.getName());
					}
					else if(f.getType()==int.class||f.getType()==Integer.class){
						fol=rss.getInt(f.getName());
					}
					else if(f.getType()==Boolean.class||f.getType()==boolean.class){
						fol=rss.getBoolean(f.getName());
					}
					else if(f.getType()==Float.class||f.getType()==float.class){
						fol=rss.getFloat(f.getName());
					}
					else if(f.getType()==Date.class){
						fol=rss.getDate(f.getName());
					}
					else if(f.getType()==Timestamp.class){
						fol=rss.getTimestamp(f.getName());
					}
					else{
						throw new CMError(f.getType() + "未处理");
					}
					f.setAccessible(true);
					f.set(o,fol);
				}
				rs.add(o);
			}
			rss.close();
		} catch (Exception e) {
			throw new CMError(e.getMessage(),e);
		}
		DB.DBClose();
		return rs;
	}
}
