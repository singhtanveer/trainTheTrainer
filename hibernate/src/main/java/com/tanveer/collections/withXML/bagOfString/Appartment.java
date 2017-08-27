package com.tanveer.collections.withXML.bagOfString;

import java.util.ArrayList;
import java.util.List;

public class Appartment {
	
	Integer appartmentId;
	String appartmentName;
	List<String> rooms = new ArrayList<String>();
	public Integer getAppartmentId() {
		return appartmentId;
	}
	public void setAppartmentId(Integer appartmentId) {
		this.appartmentId = appartmentId;
	}
	public String getAppartmentName() {
		return appartmentName;
	}
	public void setAppartmentName(String appartmentName) {
		this.appartmentName = appartmentName;
	}
	public List<String> getRooms() {
		return rooms;
	}
	public void setRooms(List<String> rooms) {
		this.rooms = rooms;
	}
	

}
