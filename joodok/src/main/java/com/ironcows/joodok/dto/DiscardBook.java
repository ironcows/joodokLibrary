package com.ironcows.joodok.dto;

public class DiscardBook {

	private String discardBookNo;
	private String bookDetailNo;
	private String librarianNo;
	private String registeredDate;
	private String modifiedDate;
	private String discardReason;
	
	public String getDiscardBookNo() {
		return discardBookNo;
	}
	public void setDiscardBookNo(String discardBookNo) {
		this.discardBookNo = discardBookNo;
	}
	
	public String getBookDetailNo() {
		return bookDetailNo;
	}
	public void setBookDetailNo(String bookDetailNo) {
		this.bookDetailNo = bookDetailNo;
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
	
	public String getDiscardReason() {
		return discardReason;
	}
	public void setDiscardReason(String discardReason) {
		this.discardReason = discardReason;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discardBookNo == null) ? 0 : discardBookNo.hashCode());
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
		DiscardBook other = (DiscardBook) obj;
		if (discardBookNo == null) {
			if (other.discardBookNo != null)
				return false;
		} else if (!discardBookNo.equals(other.discardBookNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[DiscardBook] "
				+ "/ discardBookNo=" + discardBookNo 
				+ "/ bookDetailNo=" + bookDetailNo 
				+ "/ librarianNo="	+ librarianNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate
				+ "/ discardReason=" + discardReason;
	}
	
	
	
	
}
