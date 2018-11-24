package com.ironcows.joodok.dto;

public class Reservation {

	private String reservationNo;
	private String bookDetailNo;
	private String memberNo;
	private String registeredDate;
	private String modifiedDate;
	private String status;
	
	public String getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(String reservationNo) {
		this.reservationNo = reservationNo;
	}
	
	public String getBookDetailNo() {
		return bookDetailNo;
	}
	public void setBookDetailNo(String bookDetailNo) {
		this.bookDetailNo = bookDetailNo;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reservationNo == null) ? 0 : reservationNo.hashCode());
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
		Reservation other = (Reservation) obj;
		if (reservationNo == null) {
			if (other.reservationNo != null)
				return false;
		} else if (!reservationNo.equals(other.reservationNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[Reservation]"
				+ "/ reservationNo=" + reservationNo 
				+ "/ bookDetailNo=" + bookDetailNo 
				+ "/ memberNo="	+ memberNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate 
				+ "/ status=" + status;
	}
	
	
	
}
