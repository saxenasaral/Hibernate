package com.saral.training.dto1;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		UserDetailsVehicles user1 = new UserDetailsVehicles();
		Vehicles vehicle1 = new Vehicles();
		Vehicles vehicle2 = new Vehicles();
		
		user1.setUserName("saral");
		vehicle1.setVehicleName("Ford");
		vehicle2.setVehicleName("hyundai");
		
		user1.getVehicleList().add(vehicle1);
		user1.getVehicleList().add(vehicle2);
		/*
		vehicle1.setUser(user1);
		vehicle2.setUser(user1);*/
		
		vehicle1.getUser().add(user1);
		vehicle2.getUser().add(user1);
		Session session = null;
		Transaction tx = null;
		try{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.persist(user1);
	//	session.save(vehicle1);
	//	session.save(vehicle2);
		session.getTransaction().commit();
		}
		catch(RuntimeException e){
			try{
				
			}catch(RuntimeException rb){
				
			}
		}
		session.close();
	
	
	}

}
