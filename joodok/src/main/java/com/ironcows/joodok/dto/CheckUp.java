package com.ironcows.joodok.dto;

public class CheckUp {

	private String checkUpNo;
	private String librarianNo;
	private String registeredDate;
	private String modifiedDate;
	
	public String getCheckUpNo() {
		return checkUpNo;
	}
	public void setCheckUpNo(String checkUpNo) {
		this.checkUpNo = checkUpNo;
	}
	
	public String getLibrarianNo() {
		return librarianNo;
	}
	public void setLibrarianNo(String librarianNo) {
		this.librarianNo = librarianNo;
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
		result = prime * result + ((checkUpNo == null) ? 0 : checkUpNo.hashCode());
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
		CheckUp other = (CheckUp) obj;
		if (checkUpNo == null) {
			if (other.checkUpNo != null)
				return false;
		} else if (!checkUpNo.equals(other.checkUpNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[CheckUp] "
				+ "/ checkUpNo=" + checkUpNo 
				+ "/ librarianNo=" + librarianNo 
				+ "/ registeredDate=" + registeredDate
				+ "/ modifiedDate=" + modifiedDate;
	}
	
	
	
}
