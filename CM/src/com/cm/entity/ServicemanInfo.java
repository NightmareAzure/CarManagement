package com.cm.entity;

import com.cm.core.ADD;

public class ServicemanInfo {
	private String ServicemanName;
	@ADD private String ServicemanId;
	private String ServicemanPassword;
	private String ServicemanCode;
	private String ServicemanTel;
	private Boolean ServicemanSex;
	private String ServicemanAttr;
	public String getServicemanName() {
		return ServicemanName;
	}
	public void setServicemanName(String servicemanName) {
		ServicemanName = servicemanName;
	}
	public String getServicemanId() {
		return ServicemanId;
	}
	public void setServicemanId(String servicemanId) {
		ServicemanId = servicemanId;
	}
	public String getServicemanPassword() {
		return ServicemanPassword;
	}
	public void setServicemanPassword(String servicemanPassword) {
		ServicemanPassword = servicemanPassword;
	}
	public String getServicemanCode() {
		return ServicemanCode;
	}
	public void setServicemanCode(String servicemanCode) {
		ServicemanCode = servicemanCode;
	}
	public String getServicemanTel() {
		return ServicemanTel;
	}
	public void setServicemanTel(String servicemanTel) {
		ServicemanTel = servicemanTel;
	}
	public Boolean getServicemanSex() {
		return ServicemanSex;
	}
	public void setServicemanSex(Boolean servicemanSex) {
		ServicemanSex = servicemanSex;
	}
	public String getServicemanAttr() {
		return ServicemanAttr;
	}
	public void setServicemanAttr(String servicemanAttr) {
		ServicemanAttr = servicemanAttr;
	}
	
}
