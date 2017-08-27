package com.tanveer.inheritance.withAnnotation.singleTableStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Ci")
public class Circle extends Shape {
	
	private String volumne;
	
	public String getVolumne() {
		return volumne;
	}
	public void setVolumne(String volumne) {
		this.volumne = volumne;
	}
}
