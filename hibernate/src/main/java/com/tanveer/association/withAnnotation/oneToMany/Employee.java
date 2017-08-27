package com.tanveer.association.withAnnotation.oneToMany;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employee", catalog = "tanveerDB",
uniqueConstraints = @UniqueConstraint(columnNames = "EMPLOYEE_ID"))
public class Employee {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
	Integer employeeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYER_ID", nullable = false)
	Employer employer;
	
	
	@Column(name = "EMPLOYER_TYPE", unique = false, nullable = false, length = 20)
	String employeeName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", unique = false, nullable = false, length = 10)
	Date joiningDate;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
	
	
}
