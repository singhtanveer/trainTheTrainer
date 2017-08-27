package com.tanveer.collections.withAnnotation.elemntCollecton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.tanveer.embdding.Address;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_COMPANY_ID")
	@SequenceGenerator(name = "GEN_COMPANY_ID", sequenceName = "SEQ_COMPANY_ID", initialValue = 1, allocationSize = 1)
	@Column(name = "COMPANY_ID")
	Integer companyId;
	String companyName;

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="COMPANY_ADDRESS", joinColumns=@JoinColumn(name="COMPANY_ID"))
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns={@Column(name="Address_Id")},generator="hilo-gen", type=@Type(type="long"))
	Collection<Address> addressees = new ArrayList<Address>();

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Collection<Address> getAddressees() {
		return addressees;
	}

	public void setAddressees(List<Address> addressees) {
		this.addressees = addressees;
	}

}
