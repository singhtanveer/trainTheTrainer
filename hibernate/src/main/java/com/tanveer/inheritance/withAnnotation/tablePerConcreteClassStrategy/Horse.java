package com.tanveer.inheritance.withAnnotation.tablePerConcreteClassStrategy;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ID")  
public class Horse extends Animal {
	String neigh;
	public String getNeigh() {
		return neigh;
	}
	public void setNeigh(String neigh) {
		this.neigh = neigh;
	}
}
