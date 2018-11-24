package com.ironcows.joodok.dto;

public class MetaBook {

	private String metaBookNo;
	private String registeredDate;
	private String modifiedDate;
	private String title;
	private String subTitle;
	private String volume;
	private String author;
	private String publisher;
	private String isbn;
	private String publishYear;
	private String page;
	private String price;
	private String language;
	private String ddc;
	private String nationDivision;
	private String bookType;
	
	public String getMetaBookNo() {
		return metaBookNo;
	}
	public void setMetaBookNo(String metaBookNo) {
		this.metaBookNo = metaBookNo;
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getDdc() {
		return ddc;
	}
	public void setDdc(String ddc) {
		this.ddc = ddc;
	}
	
	public String getNationDivision() {
		return nationDivision;
	}
	public void setNationDivision(String nationDivision) {
		this.nationDivision = nationDivision;
	}
	
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((metaBookNo == null) ? 0 : metaBookNo.hashCode());
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
		MetaBook other = (MetaBook) obj;
		if (metaBookNo == null) {
			if (other.metaBookNo != null)
				return false;
		} else if (!metaBookNo.equals(other.metaBookNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[MetaBook] "
				+ "/ metaBookNo=" + metaBookNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate="	+ modifiedDate 
				+ "/ title=" + title 
				+ "/ subTitle=" + subTitle 
				+ "/ volume=" + volume 
				+ "/ author=" + author 
				+ "/ publisher=" + publisher 
				+ "/ isbn=" + isbn 
				+ "/ publishYear=" + publishYear 
				+ "/ page="	+ page 
				+ "/ price=" + price 
				+ "/ language=" + language 
				+ "/ ddc=" + ddc 
				+ "/ nationDivision=" + nationDivision 
				+ "/ bookType=" + bookType;
	}
	
	
	
	
	
}
