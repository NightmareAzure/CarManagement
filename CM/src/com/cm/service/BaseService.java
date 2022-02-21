package com.cm.service;

import java.util.List;

import com.cm.dao.BaseDao;

public class BaseService {
	private BaseDao baseDao=new BaseDao();
	public void Add(Object value){
		baseDao.BaseDaoAdd(value);
	}
	public void Delete(Object value){
		baseDao.BaseDaoDelete(value);
	}
	public void Revise(Object value){
		baseDao.BaseDaoRevise(value);
	}
	public List Research(Object value){
		List<Object> rs=baseDao.BaseDaoReaserch(value);
		return rs;
	}
}
