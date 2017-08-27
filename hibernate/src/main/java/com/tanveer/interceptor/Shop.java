package com.tanveer.interceptor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "shop", catalog = "tanveerdb")
public class Shop implements java.io.Serializable, IAuditLog {
	
	private static final long serialVersionUID = 2903634715510819178L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SHOP_ID", unique = true, nullable = false)	
	private Long shopId;
	
	@Column(name = "SHOP_NAME", unique = false, nullable = false, length = 20)
	private String shopName;

	@Transient
	@Override
	public Long getId() {
		return this.shopId.longValue();
	}

	@Transient
	@Override
	public String getLogDeatil() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Shop Id : ").append(shopId).append(" Stock Name : ").append(shopName);
		return sb.toString();
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

}