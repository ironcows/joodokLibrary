package com.ironcows.joodok.dto;

public class RequestBook {

	private String requestBookNo;
	private String memberNo;
	private String registeredDate;
	private String modifiedDate;
	private String status;
	private String requestIsbn;
	private String subject;
	private String content;
	
	public String getRequestBookNo() {
		return requestBookNo;
	}
	public void setRequestBookNo(String requestBookNo) {
		this.requestBookNo = requestBookNo;
	}
	
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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
	
	public String getRequestIsbn() {
		return requestIsbn;
	}
	public void setRequestIsbn(String requestIsbn) {
		this.requestIsbn = requestIsbn;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestBookNo == null) ? 0 : requestBookNo.hashCode());
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
		RequestBook other = (RequestBook) obj;
		if (requestBookNo == null) {
			if (other.requestBookNo != null)
				return false;
		} else if (!requestBookNo.equals(other.requestBookNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[RequestBook] "
				+ "/ requestBookNo=" + requestBookNo 
				+ "/ memberNo=" + memberNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate 
				+ "/ status=" + status 
				+ "/ requestIsbn=" + requestIsbn 
				+ "/ subject=" + subject 
				+ "/ content=" + content;
	}              
	
	
	
	
	
}
