package com.tanveer.association.withAnnotation.manyToManyExtraJoinTableColumn;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer", catalog = "tanveerdb")
public class Manufacturer implements java.io.Serializable {

	private static final long serialVersionUID = -8184017820517359254L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MANUFACTURER_ID", unique = true, nullable = false)
	private Integer manufacturerId;
	
	@Column(name = "NAME", nullable = false, length = 10)
	private String name;

	@Column(name = "[DESC]", nullable = false)
	private String desc;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.manufacturer", cascade=CascadeType.ALL)
	private Set<ProductManufacturer> productManufacturers = new HashSet<ProductManufacturer>();

	public Manufacturer() {
	}

	public Manufacturer(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public Integer getManufacturerId() {
		return this.manufacturerId;
	}

	public void setManufacturerId(Integer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<ProductManufacturer> getProductManufacturers() {
		return this.productManufacturers;
	}

	public void setProductManufacturers(Set<ProductManufacturer> productManufacturers) {
		this.productManufacturers = productManufacturers;
	}

}