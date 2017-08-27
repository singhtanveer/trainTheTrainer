package com.tanveer.association.withXML.manyToManyExtraJoinTableColumn;

import java.util.HashSet;
import java.util.Set;

public class Dish implements java.io.Serializable {
	private static final long serialVersionUID = 7032723430290383393L;
	private Integer dishId;
	private String dishName;
	private Set<MenuDish> menuDishes = new HashSet<MenuDish>();
	public Integer getDishId() {
		return dishId;
	}
	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public Set<MenuDish> getMenuDishes() {
		return menuDishes;
	}
}