package com.tanveer.collections.withXML.bag;

import java.util.Collection;

public class Applicant {
	private int applicantId;
	private String applicantName;

	private Collection<Certificate> certificates;

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public Collection<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Collection<Certificate> certificates) {
		this.certificates = certificates;
	}
}