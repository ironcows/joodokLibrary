package com.ironcows.joodok.dto;

public class BookDetail {
	
	private String bookDetailNo;
	private String metaBookNo;
	private String detailLocationNo;
	private String registeredDate;
	private String modifiedDate;
	private String duplicate;
	private String applicationMark;
	private String purpose;
	private String borrowStatus;
	private String discard;
	
	public String getBookDetailNo() {
		return bookDetailNo;
	}
	public void setBookDetailNo(String bookDetailNo) {
		this.bookDetailNo = bookDetailNo;
	}
	
	public String getMetaBookNo() {
		return metaBookNo;
	}
	public void setMetaBookNo(String metaBookNo) {
		this.metaBookNo = metaBookNo;
	}
	
	public String getDetailLocationNo() {
		return detailLocationNo;
	}
	public void setDetailLocationNo(String detailLocationNo) {
		this.detailLocationNo = detailLocationNo;
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
	
	public String getDuplicate() {
		return duplicate;
	}
	public void setDuplicate(String duplicate) {
		this.duplicate = duplicate;
	}
	
	public String getApplicationMark() {
		return applicationMark;
	}
	public void setApplicationMark(String applicationMark) {
		this.applicationMark = applicationMark;
	}
	
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	public String getBorrowStatus() {
		return borrowStatus;
	}
	public void setBorrowStatus(String borrowStatus) {
		this.borrowStatus = borrowStatus;
	}
	
	public String getDiscard() {
		return discard;
	}
	public void setDiscard(String discard) {
		this.discard = discard;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookDetailNo == null) ? 0 : bookDetailNo.hashCode());
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
		BookDetail other = (BookDetail) obj;
		if (bookDetailNo == null) {
			if (other.bookDetailNo != null)
				return false;
		} else if (!bookDetailNo.equals(other.bookDetailNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[BookDetail] "
				+ "/ bookDetailNo=" + bookDetailNo 
				+ "/ metaBookNo=" + metaBookNo 
				+ "/ detailLocationNo="	+ detailLocationNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate
				+ "/ duplicate=" + duplicate 
				+ "/ applicationMark=" + applicationMark 
				+ "/ purpose=" + purpose
				+ "/ borrowStatus=" + borrowStatus 
				+ "/ discard=" + discard;
	}
	
	
	
	
}
