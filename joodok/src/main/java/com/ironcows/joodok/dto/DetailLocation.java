package com.ironcows.joodok.dto;

public class DetailLocation {
	
	private String detailLocationNo;
	private String locationNo;
	private String registeredDate;
	private String modifiedDate;
	private String detailLocationName;
	
	public String getDetailLocationNo() {
		return detailLocationNo;
	}
	public void setDetailLocationNo(String detailLocationNo) {
		this.detailLocationNo = detailLocationNo;
	}
	
	public String getLocationNo() {
		return locationNo;
	}
	public void setLocationNo(String locationNo) {
		this.locationNo = locationNo;
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
	
	public String getDetailLocationName() {
		return detailLocationName;
	}
	public void setDetailLocationName(String detailLocationName) {
		this.detailLocationName = detailLocationName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detailLocationNo == null) ? 0 : detailLocationNo.hashCode());
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
		DetailLocation other = (DetailLocation) obj;
		if (detailLocationNo == null) {
			if (other.detailLocationNo != null)
				return false;
		} else if (!detailLocationNo.equals(other.detailLocationNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[DetailLocation] "
				+ "/detailLocationNo=" + detailLocationNo 
				+ "/ locationNo=" + locationNo
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate 
				+ "/ detailLocationName=" + detailLocationName;
	}
	
	
	
	
}
