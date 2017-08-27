package com.tanveer.inheritance.withAnnotation.tablePerClassStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Calculation")  
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Calculation {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	Integer calculationId;
	public Integer getCalculationId() {
		return calculationId;
	}
	public void setCalculationId(Integer calculationId) {
		this.calculationId = calculationId;
	}
	public String getCalculationName() {
		return calculationName;
	}
	public void setCalculationName(String calculationName) {
		this.calculationName = calculationName;
	}
	String calculationName;
	
}
