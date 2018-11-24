package com.ironcows.joodok.dto;

public class Acquisition {

	private String acquisitionNo;
	private String librarianNo;
	private String registeredDate;
	private String modifiedDate;
	private String category;
	private String acquisitionIsbn;
	
	public String getAcquisitionNo() {
		return acquisitionNo;
	}
	public void setAcquisitionNo(String acquisitionNo) {
		this.acquisitionNo = acquisitionNo;
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
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getAcquisitionIsbn() {
		return acquisitionIsbn;
	}
	public void setAcquisitionIsbn(String acquisitionIsbn) {
		this.acquisitionIsbn = acquisitionIsbn;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquisitionNo == null) ? 0 : acquisitionNo.hashCode());
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
		Acquisition other = (Acquisition) obj;
		if (acquisitionNo == null) {
			if (other.acquisitionNo != null)
				return false;
		} else if (!acquisitionNo.equals(other.acquisitionNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[Acquisition]"
				+ "/ acquisitionNo=" + acquisitionNo 
				+ "/ librarianNo=" + librarianNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate 
				+ "/ category=" + category 
				+ "/ acquisitionIsbn="	+ acquisitionIsbn;
	}              
	
	
	
}
