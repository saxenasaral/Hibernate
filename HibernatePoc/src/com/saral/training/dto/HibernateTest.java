package com.saral.training.dto;

import java.util.Date;






import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		UserDetails user2 = new UserDetails();
		Address address = new Address();
		Address address2 = new Address();

		address.setStreet("kolar road");
		address.setCity("Bhopal");
		address.setPincode("465674");
		address.setState("M.P");

		address2.setStreet("sector 22");
		address2.setCity("Noida");
		address2.setPincode("201301");
		address2.setState("U.P");

		user1.setUserName("saral");
		user1.setDescription("description goes here    ");
		user1.setJoinedDate(new Date());
		user1.getListofAddresses().add(address);
		user1.getListofAddresses().add(address2);

		user2.setUserName("second user");
		user2.setDescription("description goes here for user 2");
		user2.setJoinedDate(new Date());
		Session session = null;
		Transaction tx = null;
		try {

			SessionFactory sessionFac = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFac.openSession();
			tx = session.beginTransaction();
			session.save(user1);
			tx.setTimeout(3);
			tx.commit();
			throw new Exception();
	
		} catch (Exception e) {
			try {
				System.out.println("rolling back");
				tx.rollback();
			} catch (RuntimeException rb) {

			}

		} finally {
			if(session!=null){
				session.close();
			}
		}
		session.close();

	}

}
