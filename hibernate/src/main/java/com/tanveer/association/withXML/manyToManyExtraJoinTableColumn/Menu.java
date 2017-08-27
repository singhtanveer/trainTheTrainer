package com.tanveer.association.withXML.manyToManyExtraJoinTableColumn;

import java.util.HashSet;
import java.util.Set;

public class Menu implements java.io.Serializable {
	private static final long serialVersionUID = 7032723430290383393L;
	private Integer menuId;
	private String menuName;
	private Set<MenuDish> menuDishes = new HashSet<MenuDish>();
	public Set<MenuDish> getMenuDishes() {
		return menuDishes;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
}