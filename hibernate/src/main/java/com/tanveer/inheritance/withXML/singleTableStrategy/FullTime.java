package com.tanveer.inheritance.withXML.singleTableStrategy;

public class FullTime extends Worker {
	private String perks;
	Integer hours;

	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	public String getPerks() {
		return perks;
	}
	public void setPerks(String perks) {
		this.perks = perks;
	}
}
