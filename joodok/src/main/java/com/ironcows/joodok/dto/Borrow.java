package com.ironcows.joodok.dto;

public class Borrow {

	private String borrowNo;
	private String memberNo;
	private String bookDetailNo;
	private String registeredDate;
	private String modifiedDate;
	private String status;
	private String dueDate;
	private String returnedDate;
	
	public String getBorrowNo() {
		return borrowNo;
	}
	public void setBorrowNo(String borrowNo) {
		this.borrowNo = borrowNo;
	}
	
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	
	public String getBookDetailNo() {
		return bookDetailNo;
	}
	public void setBookDetailNo(String bookDetailNo) {
		this.bookDetailNo = bookDetailNo;
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(String returnedDate) {
		this.returnedDate = returnedDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((borrowNo == null) ? 0 : borrowNo.hashCode());
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
		Borrow other = (Borrow) obj;
		if (borrowNo == null) {
			if (other.borrowNo != null)
				return false;
		} else if (!borrowNo.equals(other.borrowNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[Borrow] "
				+ "/ borrowNo=" + borrowNo 
				+ "/ memberNo=" + memberNo 
				+ "/ bookDetailNo=" + bookDetailNo
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate 
				+ "/ status=" + status
				+ "/ dueDate=" + dueDate 
				+ "/ returnedDate=" + returnedDate;
	}
	
	
	
}
