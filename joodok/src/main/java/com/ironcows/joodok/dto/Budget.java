package com.ironcows.joodok.dto;

import java.math.BigDecimal;

public class Budget {

	private String budgetNo;
	private String registeredDate;
	private String modifiedDate;
	private String year;
	private String quarter;
	private BigDecimal allocation;
	private BigDecimal remainder;
	private BigDecimal limit;
	private String budgetClassification;
	
	public String getBudgetNo() {
		return budgetNo;
	}
	public void setBudgetNo(String budgetNo) {
		this.budgetNo = budgetNo;
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
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	
	public BigDecimal getAllocation() {
		return allocation;
	}
	public void setAllocation(BigDecimal allocation) {
		this.allocation = allocation;
	}
	
	public BigDecimal getRemainder() {
		return remainder;
	}
	public void setRemainder(BigDecimal remainder) {
		this.remainder = remainder;
	}
	
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	
	public String getBudgetClassification() {
		return budgetClassification;
	}
	public void setBudgetClassification(String budgetClassification) {
		this.budgetClassification = budgetClassification;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budgetNo == null) ? 0 : budgetNo.hashCode());
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
		Budget other = (Budget) obj;
		if (budgetNo == null) {
			if (other.budgetNo != null)
				return false;
		} else if (!budgetNo.equals(other.budgetNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[Budget]"
				+ "/ budgetNo=" + budgetNo 
				+ "/ registeredDate=" + registeredDate 
				+ "/ modifiedDate=" + modifiedDate
				+ "/ year=" + year 
				+ "/ quarter=" + quarter 
				+ "/ allocation=" + allocation 
				+ "/ remainder=" + remainder
				+ "/ limit=" + limit 
				+ "/ budgetClassification=" + budgetClassification;
	}
	
	
	
}
