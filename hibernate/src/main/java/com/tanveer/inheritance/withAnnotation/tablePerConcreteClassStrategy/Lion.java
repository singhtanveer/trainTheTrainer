package com.tanveer.inheritance.withAnnotation.tablePerConcreteClassStrategy;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ID")  
public class Lion extends Animal {
	String roar;
	public String getRoar() {
		return roar;
	}
	public void setRoar(String roar) {
		this.roar = roar;
	}
}
