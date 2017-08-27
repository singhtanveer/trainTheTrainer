package com.tanveer.association.withXML.oneToMany;

import java.util.HashSet;
import java.util.Set;

public class State {
	
	Integer stateId;
	String stateName;
	Float stateArea;
	Set<City> cities = new HashSet<City>();
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Float getStateArea() {
		return stateArea;
	}
	public void setStateArea(Float stateArea) {
		this.stateArea = stateArea;
	}
	public Set<City> getCities() {
		return cities;
	}
	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	

}
