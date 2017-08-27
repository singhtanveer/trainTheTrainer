package com.tanveer.association.withAnnotation.manyToManyExtraJoinTableColumn;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "product_manufacturer", catalog = "tanveerdb")
@AssociationOverrides({
		@AssociationOverride(name = "pk.product", joinColumns = @JoinColumn(name = "PRODUCT_ID")),
		@AssociationOverride(name = "pk.manufacturer", joinColumns = @JoinColumn(name = "MANUFACTURER_ID")) })
public class ProductManufacturer implements java.io.Serializable {

	private static final long serialVersionUID = 811078316313850912L;
	
	private ProductManufacturerId pk = new ProductManufacturerId();
	private Date manufacturedDate;

	public ProductManufacturer() {
	}

	@EmbeddedId
	public ProductManufacturerId getPk() {
		return pk;
	}

	public void setPk(ProductManufacturerId pk) {
		this.pk = pk;
	}

	@Transient
	public Product getProduct() {
		return getPk().getProduct();
	}

	public void setProduct(Product product) {
		getPk().setProduct(product);
	}

	@Transient
	public Manufacturer getManufacturer() {
		return getPk().getManufacturer();
	}

	public void setManufacturer(Manufacturer manufacturer) {
		getPk().setManufacturer(manufacturer);
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MANUFACTURED_DATE", nullable = false, length = 10)
	public Date getManufacturedDate() {
		return this.manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ProductManufacturer that = (ProductManufacturer) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}