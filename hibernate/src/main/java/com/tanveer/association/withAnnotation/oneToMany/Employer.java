package com.tanveer.association.withAnnotation.oneToMany;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employer", catalog = "tanveerDB", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMPLOYER_NAME"),
		@UniqueConstraint(columnNames = "EMPLOYER_TYPE") })
public class Employer {
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EMPLOYER_ID", unique = true, nullable = false)
	private Integer employerId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employer")
	private Set<Employee> employee = new HashSet<Employee>();
	
	@Column(name = "EMPLOYER_NAME", unique = true, nullable = false, length = 20)
	private String employerName;
	
	@Column(name = "EMPLOYER_TYPE", unique = true, nullable = false, length = 20)
	String employerType;

	
	public Integer getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmployerType() {
		return employerType;
	}

	public void setEmployerType(String employerType) {
		this.employerType = employerType;
	}


}
