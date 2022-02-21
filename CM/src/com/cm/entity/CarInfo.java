package com.cm.entity;

import java.sql.Date;

import com.cm.core.Id;

public class CarInfo {
	private String CarCode;
	private String CarModel;
	private String CarArea;
	private Date CarDate;
	private String CarBrand;
	@Id private Integer CarId;
	private String ClientId;
	public String getCarCode() {
		return CarCode;
	}
	public void setCarCode(String carCode) {
		CarCode = carCode;
	}
	public String getCarModel() {
		return CarModel;
	}
	public void setCarModel(String carModel) {
		CarModel = carModel;
	}
	public String getCarArea() {
		return CarArea;
	}
	public void setCarArea(String carArea) {
		CarArea = carArea;
	}
	public Date getCarDate() {
		return CarDate;
	}
	public void setCarDate(Date carDate) {
		CarDate = carDate;
	}
	public String getCarBrand() {
		return CarBrand;
	}
	public void setCarBrand(String carBrand) {
		CarBrand = carBrand;
	}
	public Integer getCarId() {
		return CarId;
	}
	public void setCarId(Integer carId) {
		CarId = carId;
	}
	public String getClientId() {
		return ClientId;
	}
	public void setClientId(String clientId) {
		ClientId = clientId;
	}
	
}
