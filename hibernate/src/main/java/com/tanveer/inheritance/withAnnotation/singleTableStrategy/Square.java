package com.tanveer.inheritance.withAnnotation.singleTableStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Sq")
public class Square extends Shape {
	
	private String area;

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
}
