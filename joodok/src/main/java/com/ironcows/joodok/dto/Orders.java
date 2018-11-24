package com.ironcows.joodok.dto;

public class Orders {

	private String orderNo;
	private String librarianNo;
	private String tradeEnterpriseNo;
	private String registeredDate;
	private String modifiedDate;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getLibrarianNo() {
		return librarianNo;
	}
	public void setLibrarianNo(String librarianNo) {
		this.librarianNo = librarianNo;
	}
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
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
		Orders other = (Orders) obj;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo 
				+ ", librarianNo=" + librarianNo 
				+ ", tradeEnterpriseNo=" + tradeEnterpriseNo 
				+ ", registeredDate=" + registeredDate 
				+ ", modifiedDate=" + modifiedDate + "]";
	}
	

	
	
	
}
