package com.cm.entity;

import com.cm.core.ADD;

public class ServicemanInfoToBill {
	@ADD private Integer BillNumber;
	@ADD private String ServicemanId;
	private Float ServiceCost;
	public Integer getBillNumber() {
		return BillNumber;
	}
	public void setBillNumber(Integer billNumber) {
		BillNumber = billNumber;
	}
	public String getServicemanId() {
		return ServicemanId;
	}
	public void setServicemanId(String servicemanId) {
		ServicemanId = servicemanId;
	}
	public Float getServiceCost() {
		return ServiceCost;
	}
	public void setServiceCost(Float serviceCost) {
		ServiceCost = serviceCost;
	}
	
}
