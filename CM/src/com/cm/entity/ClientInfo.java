package com.cm.entity;

import java.sql.Date;

import com.cm.core.ADD;

public class ClientInfo {
	@ADD private String ClientId;
	private String ClientPassword;
	private String ClientName;
	private Boolean ClientSex;
	private String ClientCode;
	private String ClientTel;
	private Date ClientRegisterTime;
	private String ClientPhone;
	public String getClientId() {
		return ClientId;
	}
	public void setClientId(String clientId) {
		ClientId = clientId;
	}
	public String getClientPassword() {
		return ClientPassword;
	}
	public void setClientPassword(String clientPassword) {
		ClientPassword = clientPassword;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	public Boolean getClientSex() {
		return ClientSex;
	}
	public void setClientSex(Boolean clientSex) {
		ClientSex = clientSex;
	}
	public String getClientCode() {
		return ClientCode;
	}
	public void setClientCode(String clientCode) {
		ClientCode = clientCode;
	}
	public String getClientTel() {
		return ClientTel;
	}
	public void setClientTel(String clientTel) {
		ClientTel = clientTel;
	}
	public Date getClientRegisterTime() {
		return ClientRegisterTime;
	}
	public void setClientRegisterTime(Date clientRegisterTime) {
		ClientRegisterTime = clientRegisterTime;
	}
	public String getClientPhone() {
		return ClientPhone;
	}
	public void setClientPhone(String clientPhone) {
		ClientPhone = clientPhone;
	}
	
}
