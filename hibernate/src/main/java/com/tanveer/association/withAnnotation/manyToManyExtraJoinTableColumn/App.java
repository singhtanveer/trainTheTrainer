package com.tanveer.association.withAnnotation.manyToManyExtraJoinTableColumn;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate many to many - join table + extra column (Annotation)");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Product product = new Product("Sn", "Sedan");

		Manufacturer manufacturer1 = new Manufacturer("Maruti", "Suzuki COMPANY");
		session.save(manufacturer1);

		ProductManufacturer productManufacturer = new ProductManufacturer();
		productManufacturer.setProduct(product);
		productManufacturer.setManufacturer(manufacturer1);
		productManufacturer.setManufacturedDate(new Date());

		product.getProductManufacturers().add(productManufacturer);

		Manufacturer manufacturer2 = new Manufacturer("Hyundai", "Japanese COMPANY");
		session.save(manufacturer2);

		productManufacturer = new ProductManufacturer();
		productManufacturer.setProduct(product);
		productManufacturer.setManufacturer(manufacturer2);
		productManufacturer.setManufacturedDate(new Date());

		product.getProductManufacturers().add(productManufacturer);

		session.save(product);
		
		session.getTransaction().commit();
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Manufacturer manufacturer = new Manufacturer("Tata", "Indian COMPANY");
		
		Product product1 = new Product("Sv", "SUV");
		session.save(product1);
		productManufacturer = new ProductManufacturer();
		productManufacturer.setManufacturer(manufacturer);
		productManufacturer.setProduct(product1);
		productManufacturer.setManufacturedDate(new Date());
		manufacturer.getProductManufacturers().add(productManufacturer);

		Product product2 = new Product("Hk", "Hatchback");
		session.save(product2);
		productManufacturer = new ProductManufacturer();
		productManufacturer.setManufacturer(manufacturer);
		productManufacturer.setProduct(product2);
		productManufacturer.setManufacturedDate(new Date());
		manufacturer.getProductManufacturers().add(productManufacturer);

		session.save(manufacturer);

		session.getTransaction().commit();
		session.close();
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Product> products = (List<Product>) session.createQuery("from Product where productName='Sedan'").list();
		List<Manufacturer> manufacturers = (List<Manufacturer>) session.createQuery("from Manufacturer where name='Tata'").list();

		manufacturer = manufacturers.get(0);
		product = products.get(0);
		
		session.save(product);
		productManufacturer = new ProductManufacturer();
		productManufacturer.setManufacturer(manufacturer);
		productManufacturer.setProduct(product);
		productManufacturer.setManufacturedDate(new Date());
		manufacturer.getProductManufacturers().add(productManufacturer);

		session.save(manufacturer);

		session.getTransaction().commit();
		session.close();

		System.out.println("Done");
	}
}
