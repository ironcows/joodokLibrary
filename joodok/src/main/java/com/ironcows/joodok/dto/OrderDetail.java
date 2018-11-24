package com.ironcows.joodok.dto;


public class OrderDetail {

	private String orderDetailNo;
	private String orderNo;
	private String registeredDate;
	private String modifiedDate;
	private String orderIsbn;
	private String orderCount;
	
	public String getOrderDetailNo() {
		return orderDetailNo;
	}
	public void setOrderDetailNo(String orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	
	public String getOrderIsbn() {
		return orderIsbn;
	}
	public void setOrderIsbn(String orderIsbn) {
		this.orderIsbn = orderIsbn;
	}
	
	public String getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderDetailNo == null) ? 0 : orderDetailNo.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
		if (orderDetailNo == null) {
			if (other.orderDetailNo != null)
				return false;
		} else if (!orderDetailNo.equals(other.orderDetailNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[OrderDetail]"
				+ "/ orderDetailNo=" + orderDetailNo 
				+ "/ orderNo=" + orderNo 
				+ "/ registeredDate=" + registeredDate
				+ "/ modifiedDate=" + modifiedDate 
				+ "/ orderIsbn=" + orderIsbn 
				+ "/ orderCount=" + orderCount;
	}
	
	
}
