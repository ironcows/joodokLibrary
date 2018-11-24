package com.ironcows.joodok.dto;

public class Grade {
	
	private String gradeNo;
	private String registeredDate;
	private String modifiedDate;
	private String position;
	private String possibleBorrowDay;
	
	public String getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(String gradeNo) {
		this.gradeNo = gradeNo;
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
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPossibleBorrowDay() {
		return possibleBorrowDay;
	}
	public void setPossibleBorrowDay(String possibleBorrowDay) {
		this.possibleBorrowDay = possibleBorrowDay;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gradeNo == null) ? 0 : gradeNo.hashCode());
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
		Grade other = (Grade) obj;
		if (gradeNo == null) {
			if (other.gradeNo != null)
				return false;
		} else if (!gradeNo.equals(other.gradeNo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "[Grade]"
				+ "/ gradeNo=" + gradeNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate
				+ "/ position=" + position 
				+ "/ possibleBorrowDay=" + possibleBorrowDay;
	}
	
	
	
}
