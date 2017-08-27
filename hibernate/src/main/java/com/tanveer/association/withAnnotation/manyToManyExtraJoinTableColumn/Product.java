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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "product", catalog = "tanveerdb", uniqueConstraints = {
		@UniqueConstraint(columnNames = "PRODUCT_NAME"),
		@UniqueConstraint(columnNames = "PRODUCT_CODE") })
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 7032723430290383393L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	private Integer productId;

	@Column(name = "PRODUCT_CODE", unique = true, nullable = false, length = 10)
	private String productCode;
	
	@Column(name = "PRODUCT_NAME", unique = true, nullable = false, length = 20)
	private String productName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product", cascade=CascadeType.ALL)
	private Set<ProductManufacturer> productManufacturers = new HashSet<ProductManufacturer>(0);

	public Product() {}
	
	public Product(String productCode, String productName) {
		this.productCode = productCode;
		this.productName = productName;
	}

	public Product(String productCode, String productName,
			Set<ProductManufacturer> productManufacturers) {
		this.productCode = productCode;
		this.productName = productName;
		this.productManufacturers = productManufacturers;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Set<ProductManufacturer> getProductManufacturers() {
		return this.productManufacturers;
	}

	public void setProductManufacturers(Set<ProductManufacturer> productManufacturers) {
		this.productManufacturers = productManufacturers;
	}

}