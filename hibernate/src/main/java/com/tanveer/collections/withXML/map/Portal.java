package com.tanveer.collections.withXML.map;

import java.util.HashMap;
import java.util.Map;

public class Portal {
	
	Integer portalId;
	String portalName;
	Map<String, Credentials> users = new HashMap<String, Credentials>();
	public Integer getPortalId() {
		return portalId;
	}
	public void setPortalId(Integer portalId) {
		this.portalId = portalId;
	}
	public String getPortalName() {
		return portalName;
	}
	public void setPortalName(String portalName) {
		this.portalName = portalName;
	}
	public Map<String, Credentials> getUsers() {
		return users;
	}
	public void setUsers(Map<String, Credentials> users) {
		this.users = users;
	}
	
	

}
