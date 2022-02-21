package com.cm.entity;

import java.sql.Date;

import com.cm.core.Id;

public class Bill {
	@Id private Integer BillNumber;
	private Integer CarId;
	private Float BillPartCost;
	private Float BillServiceCost;
	private Integer BillState;
	private Date BillDate;
	private String BillInspector;
	private String problem;
	public Integer getBillNumber() {
		return BillNumber;
	}
	public void setBillNumber(Integer billNumber) {
		BillNumber = billNumber;
	}
	public Integer getCarId() {
		return CarId;
	}
	public void setCarId(Integer carId) {
		CarId = carId;
	}
	public Float getBillPartCost() {
		return BillPartCost;
	}
	public void setBillPartCost(Float billPartCost) {
		BillPartCost = billPartCost;
	}
	public Float getBillServiceCost() {
		return BillServiceCost;
	}
	public void setBillServiceCost(Float billServiceCost) {
		BillServiceCost = billServiceCost;
	}
	public Integer getBillState() {
		return BillState;
	}
	public void setBillState(Integer billState) {
		BillState = billState;
	}
	public Date getBillDate() {
		return BillDate;
	}
	public void setBillDate(Date billDate) {
		BillDate = billDate;
	}
	public String getBillInspector() {
		return BillInspector;
	}
	public void setBillInspector(String billInspector) {
		BillInspector = billInspector;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	
}
