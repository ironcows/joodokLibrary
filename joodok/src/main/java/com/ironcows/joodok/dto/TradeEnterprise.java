package com.ironcows.joodok.dto;

public class TradeEnterprise {

	private String tradeEnterpriseNo;
	private String registeredDate;
	private String modifiedDate;
	private String name;
	private String type;
	private String category;
	private String bankName;
	private String account;
	private String creditGrade;
	private String deliveryPeriod;
	private String contactNumber;
	private String fax;
	private String address;
	private String webAddress;
	
	public String getTradeEnterpriseNo() {
		return tradeEnterpriseNo;
	}
	public void setTradeEnterpriseNo(String tradeEnterpriseNo) {
		this.tradeEnterpriseNo = tradeEnterpriseNo;
	}
	
	public String getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getCreditGrade() {
		return creditGrade;
	}
	public void setCreditGrade(String creditGrade) {
		this.creditGrade = creditGrade;
	}
	
	public String getDeliveryPeriod() {
		return deliveryPeriod;
	}
	public void setDeliveryPeriod(String deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getWebAddress() {
		return webAddress;
	}
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tradeEnterpriseNo == null) ? 0 : tradeEnterpriseNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeEnterprise other = (TradeEnterprise) obj;
		if (tradeEnterpriseNo == null) {
			if (other.tradeEnterpriseNo != null)
				return false;
		} else if (!tradeEnterpriseNo.equals(other.tradeEnterpriseNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[TradeEnterprise]"
				+ "/ tradeEnterpriseNo=" + tradeEnterpriseNo 
				+ "/ registeredDate=" + registeredDate
				+ "/ modifiedDate=" + modifiedDate 
				+ "/ name=" + name 
				+ "/ type=" + type 
				+ "/ category=" + category
				+ "/ bankName=" + bankName 
				+ "/ account=" + account 
				+ "/ creditGrade=" + creditGrade
				+ "/ deliveryPeriod=" + deliveryPeriod 
				+ "/ contactNumber=" + contactNumber 
				+ "/ fax=" + fax
				+ "/ address=" + address 
				+ "/ webAddress=" + webAddress;
	}
	
	
	
}
