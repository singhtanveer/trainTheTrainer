package com.tanveer.association.withXML.manyToManyExtraJoinTableColumn;

public class MenuDishId implements java.io.Serializable {
	private static final long serialVersionUID = -673347532267697932L;
	private Menu menu;
	private Dish dish;
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dish == null) ? 0 : dish.hashCode());
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
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
		MenuDishId other = (MenuDishId) obj;
		if (dish == null) {
			if (other.dish != null)
				return false;
		} else if (!dish.equals(other.dish))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		return true;
	}
	
}