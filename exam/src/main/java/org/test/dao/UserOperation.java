package org.test.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.test.dto.User;
import org.test.dto.foodOrder;

public class UserOperation {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t = manager.getTransaction();
	Scanner sc = new Scanner(System.in);

	public User saveUserAndFoodorder() {
		System.out.println("enter name, gender, email, password, phone");
		String name = sc.nextLine();
		String gender = sc.next();
		String email = sc.next();
		String password = sc.next();
		long phone = sc.nextLong();

		User u1 = new User();
		u1.setEmail(email);
		u1.setGender(gender);
		u1.setName(name);
		u1.setPassword(password);
		u1.setPhone(phone);
		
		System.out.println("enter item name, address, price");
		String itemName = sc.next();
		String address = sc.next();
		double price = sc.nextDouble();
		foodOrder f1 = new foodOrder();
		f1.setAddress(address);
		f1.setItemName(itemName);
		f1.setPrice(price);
		f1.setUser(u1);
		manager.merge(u1);
		manager.merge(f1);
		t.begin();
		t.commit();
		System.out.println("data saved sucessfully");
		return u1;
	}

	public void veifyUser() {
		System.out.println("enter email, password");
		String email = sc.next();
		String password = sc.next();

		Query q = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			User u = (User) q.getSingleResult();
			if(u!=null) {
			System.out.println(u.getName() + " is existed user...");
			}
		} catch (Exception e) {
			System.out.println("invalid input");
		}
	}

	public User updateUserAndFoodorder() {
		System.out.println("enter UPDATED name, gender, email, password, phone");
		String name = sc.nextLine();
		String gender = sc.next();
		String email = sc.next();
		String password = sc.next();
		long phone = sc.nextLong();

		User u1 = new User();
		u1.setEmail(email);
		u1.setGender(gender);
		u1.setName(name);
		u1.setPassword(password);
		u1.setPhone(phone);
		manager.merge(u1);
		
		System.out.println("enter UPDATED item name, address, price");
		String itemName = sc.next();
		String address = sc.next();
		double price = sc.nextDouble();
		foodOrder f1 = new foodOrder();
		f1.setAddress(address);
		f1.setItemName(itemName);
		f1.setPrice(price);
		f1.setUser(u1);
		
		manager.merge(f1);
		t.begin();
		t.commit();
		System.out.println("data updated sucessfully");
		return u1;
	}
	
	public void fetchFoodorderByUserId() {
		System.out.println("enter user id = ");
		int id = sc.nextInt();
		User u = new User();
		User user = manager.find(User.class, id);
	       if(user!=null) {
	    	   List<foodOrder> fo = user.getFood_list();
	   		for(foodOrder f:fo) {
	   			System.out.println(f.getId());
	   			System.out.println(f.getItemName());
	   			System.out.println(f.getAddress());
	   			System.out.println(f.getPrice());
	   			System.out.println(f.getOrdered_time());
	   			System.out.println(f.getDel_time());
	   			System.out.println("===============");
	    	   }
	   		
	       }
	}
	
	public void fetchFoodorderByUserdata() {
		System.out.println("enter user email and password ");
		String email = sc.next();
		String password = sc.next();
		Query q = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
		          User u = (User)q.getSingleResult();
		       if(u!=null) {
		    	       List<foodOrder> fo = u.getFood_list();
		    	   for(foodOrder f:fo) {
		   			System.out.println(f.getId());
		   			System.out.println(f.getItemName());
		   			System.out.println(f.getAddress());
		   			System.out.println(f.getPrice());
		   			System.out.println(f.getOrdered_time());
		   			System.out.println(f.getDel_time());
		   			System.out.println("===============");
		    	   }
		       }
		       
		}catch(NoResultException e) {
			System.out.println("invalid dname");
		}

	}
	
	public void deleteFoodOrder() {
		System.out.println("enter food order id = ");
		int id = sc.nextInt();
		foodOrder d = new foodOrder();
		foodOrder f = manager.find(foodOrder.class, id);
		if(f!=null) {
			manager.remove(f);
			t.begin();
			t.commit();
			System.out.println("order deleted....");
		}
	}

}
