package com.ironcows.joodok.dto;

public class CheckUpList {

	private String checkUpListNo;
	private String acquisitionNo;
	private String checkUpNo;
	private String registeredDate;
	private String modifiedDate;
	private String checkUpResult;
	private String memo;
	private String checkUpIsbn;
	private String registeredOrNot;
	
	public String getCheckUpListNo() {
		return checkUpListNo;
	}
	public void setCheckUpListNo(String checkUpListNo) {
		this.checkUpListNo = checkUpListNo;
	}
	
	public String getAcquisitionNo() {
		return acquisitionNo;
	}
	public void setAcquisitionNo(String acquisitionNo) {
		this.acquisitionNo = acquisitionNo;
	}
	
	public String getCheckUpNo() {
		return checkUpNo;
	}
	public void setCheckUpNo(String checkUpNo) {
		this.checkUpNo = checkUpNo;
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
	
	public String getCheckUpResult() {
		return checkUpResult;
	}
	public void setCheckUpResult(String checkUpResult) {
		this.checkUpResult = checkUpResult;
	}
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getCheckUpIsbn() {
		return checkUpIsbn;
	}
	public void setCheckUpIsbn(String checkUpIsbn) {
		this.checkUpIsbn = checkUpIsbn;
	}
	
	public String getRegisteredOrNot() {
		return registeredOrNot;
	}
	public void setRegisteredOrNot(String registeredOrNot) {
		this.registeredOrNot = registeredOrNot;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkUpListNo == null) ? 0 : checkUpListNo.hashCode());
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
		CheckUpList other = (CheckUpList) obj;
		if (checkUpListNo == null) {
			if (other.checkUpListNo != null)
				return false;
		} else if (!checkUpListNo.equals(other.checkUpListNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[CheckUpList]"
				+ "/ checkUpListNo=" + checkUpListNo 
				+ "/ acquisitionNo=" + acquisitionNo 
				+ "/ checkUpNo=" + checkUpNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate
				+ "/ checkUpResult=" + checkUpResult 
				+ "/ memo=" + memo 
				+ "/ checkUpIsbn=" + checkUpIsbn
				+ "/ registeredOrNot=" + registeredOrNot;
	}
	
	
	
}
