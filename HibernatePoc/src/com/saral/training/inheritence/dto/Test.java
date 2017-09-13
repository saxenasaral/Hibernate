package com.saral.training.inheritence.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	

	public static void main(String[] args) {

		VehicleParent vehicle = new VehicleParent();
		vehicle.setVehicleName("car");		
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("BMW");
		car.setSteeringWheel("BMW steering wheel");
				
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("thunderBird");
		bike.setSteeringHandler("bike steering handler");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(car);
		session.save(bike);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
