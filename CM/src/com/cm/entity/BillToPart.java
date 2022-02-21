package com.cm.entity;

import com.cm.core.ADD;

public class BillToPart {
	@ADD private Integer BillNumber;
	@ADD private String PartModel;
	private Integer Number;
	public Integer getBillNumber() {
		return BillNumber;
	}
	public void setBillNumber(Integer billNumber) {
		BillNumber = billNumber;
	}
	public String getPartModel() {
		return PartModel;
	}
	public void setPartModel(String partModel) {
		PartModel = partModel;
	}
	public Integer getNumber() {
		return Number;
	}
	public void setNumber(Integer number) {
		Number = number;
	}
	
}