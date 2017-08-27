package com.tanveer.embdding;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HouseOwner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer houseOwnerId;
	
	String houseOwnerName;
	
	@Embedded
	Address address;

	public Integer getHouseOwnerId() {
		return houseOwnerId;
	}

	public void setHouseOwnerId(Integer houseOwnerId) {
		this.houseOwnerId = houseOwnerId;
	}

	public String getHouseOwnerName() {
		return houseOwnerName;
	}

	public void setHouseOwnerName(String houseOwnerName) {
		this.houseOwnerName = houseOwnerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
