package com.tanveer.inheritance.withXML.singleTableStrategy;

public class Contractor extends Worker {
	Integer wages;
	Integer hours;
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	public Integer getWages() {
		return wages;
	}
	public void setWages(Integer wages) {
		this.wages = wages;
	}
}
