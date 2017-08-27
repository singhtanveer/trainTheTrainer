package com.tanveer.association.withXML.manyToManyExtraJoinTableColumn;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Menu menu = new Menu();
		menu.setMenuName("HyattMenu");
		
		Dish dish1 = new Dish();
		dish1.setDishName("Paneer Tikka");
		
		Dish dish2 = new Dish();
		dish2.setDishName("Veg Jalfarezi");
		
		MenuDish menuDish1 = new MenuDish();
		menuDish1.setMenu(menu);
		menuDish1.setDish(dish1);
		menuDish1.setQuantity(1);
		
		MenuDish menuDish2 = new MenuDish();
		menuDish2.setMenu(menu);
		menuDish2.setDish(dish2);
		menuDish2.setQuantity(2);

		menu.getMenuDishes().add(menuDish1);
		menu.getMenuDishes().add(menuDish2);
		
		session.save(dish1);
		session.save(dish2);
		session.save(menu);
		
		Dish dish = new Dish();
		dish.setDishName("HaraBhara Kabab");
		
		Menu menu1 = new Menu();
		menu1.setMenuName("TajMenu");
		
		Menu menu2 = new Menu();
		menu2.setMenuName("RadissonMenu");
		
		MenuDish menuDish3 = new MenuDish();
		menuDish3.setDish(dish);
		menuDish3.setMenu(menu1);
		menuDish3.setQuantity(3);
		dish.getMenuDishes().add(menuDish3);
		
		MenuDish menuDish4 = new MenuDish();
		menuDish4.setDish(dish);
		menuDish4.setMenu(menu2);
		menuDish4.setQuantity(4);
		dish.getMenuDishes().add(menuDish4);
		
		session.save(menu1);
		session.save(menu2);
		session.save(dish);

		session.getTransaction().commit();
		session.close();

		System.out.println("Done");
	}
}
