package com.ironcows.joodok.dto;

public class Librarian {

	private String librarianNo;
	private String registeredDate;
	private String modifiedDate;
	private String id;
	private String password;
	private String name;
	private String contactNumber;
	
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((librarianNo == null) ? 0 : librarianNo.hashCode());
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
		Librarian other = (Librarian) obj;
		if (librarianNo == null) {
			if (other.librarianNo != null)
				return false;
		} else if (!librarianNo.equals(other.librarianNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[Librarian] "
				+ "/ librarianNo=" + librarianNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate="	+ modifiedDate 
				+ "/ id=" + id 
				+ "/ password=" + password 
				+ "/ name=" + name 
				+ "/ contactNumber=" + contactNumber;
	}
	
	
}
