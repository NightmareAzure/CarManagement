package com.cm.dao;

import java.util.List;

import com.cm.util.SQLHelper;

public class BaseDao {
	SQLHelper SQL=new SQLHelper();
	public void BaseDaoAdd(Object value){
		SQL.CreateAddSQL(value);
	}
	public void BaseDaoDelete(Object value){
		SQL.CreateDeleteSQL(value);
	}
	public void BaseDaoRevise(Object value){
		SQL.CreateReviseSQL(value);
	}
	public List BaseDaoReaserch(Object value){
		List<Object> rs=SQL.CreateReserchSQL(value);
		return rs;
	}
}
