package com.tanveer.association.withXML.oneToOneUsingManyToOne;

import java.util.Date;

public class License {
	
	Integer licenseId;
	String licenseNo;
	Date issueDate;
	Driver driver;
	public Integer getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(Integer licenseId) {
		this.licenseId = licenseId;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}
