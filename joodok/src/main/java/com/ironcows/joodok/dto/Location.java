package com.ironcows.joodok.dto;

public class Location {
	
	private String locationNo;
	private String registeredDate;
	private String modifiedDate;
	private String locationName;
	
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
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationNo == null) ? 0 : locationNo.hashCode());
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
		Location other = (Location) obj;
		if (locationNo == null) {
			if (other.locationNo != null)
				return false;
		} else if (!locationNo.equals(other.locationNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[Location]"
				+ "/locationNo=" + locationNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate 
				+ "/ locationName=" + locationName ;
	}
	
	
	
	
}
