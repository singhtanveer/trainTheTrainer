package com.tanveer.association.withXML.manyToManyExtraJoinTableColumn;

import javax.persistence.Transient;

public class MenuDish implements java.io.Serializable {
	private static final long serialVersionUID = -6577258911842743583L;
	private MenuDishId menuDishId = new MenuDishId();
	private Integer quantity;
	public MenuDishId getMenuDishId() {
		return menuDishId;
	}
	public void setMenuDishId(MenuDishId menuDishId) {
		this.menuDishId = menuDishId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Transient
	public Menu getMenu() {
		return getMenuDishId().getMenu();
	}
	public void setMenu(Menu menu) {
		getMenuDishId().setMenu(menu);
	}
	@Transient
	public Dish getDish() {
		return getMenuDishId().getDish();
	}

	public void setDish(Dish dish) {
		getMenuDishId().setDish(dish);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuDishId == null) ? 0 : menuDishId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuDish other = (MenuDish) obj;
		if (menuDishId == null) {
			if (other.menuDishId != null)
				return false;
		} else if (!menuDishId.equals(other.menuDishId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	
}