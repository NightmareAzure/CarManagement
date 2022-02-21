package com.cm.entity;

import com.cm.core.ADD;

public class Part {
	@ADD private String PartModel;
	private Integer PartNumber;
	private Float PartPrice;
	private String PartVender;
	private String PartProduceArea;
	public String getPartModel() {
		return PartModel;
	}
	public void setPartModel(String partModel) {
		PartModel = partModel;
	}
	public Integer getPartNumber() {
		return PartNumber;
	}
	public void setPartNumber(Integer partNumber) {
		PartNumber = partNumber;
	}
	public Float getPartPrice() {
		return PartPrice;
	}
	public void setPartPrice(Float partPrice) {
		PartPrice = partPrice;
	}
	public String getPartVender() {
		return PartVender;
	}
	public void setPartVender(String partVender) {
		PartVender = partVender;
	}
	public String getPartProduceArea() {
		return PartProduceArea;
	}
	public void setPartProduceArea(String partProduceArea) {
		PartProduceArea = partProduceArea;
	}
	
}
