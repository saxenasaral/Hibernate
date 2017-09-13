package com.saral.training.crud.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		UserDetailsCrud user= null;
		
		/* CREATE CRUD operation
		 * for(int i=0;i<10;i++){
			user=new UserDetailsCrud();
			user.setUserName("user"+i);
			session.save(user);
		}
		 */
		
		/* RETRIEVE CRUD operation
		user = null;
		user = (UserDetailsCrud)session.get(UserDetailsCrud.class, 5);
		System.out.println("user with"+user.getUserId()+" is "+user.getUserName());
		*/
		/* DELETE CRUD operation
		user = (UserDetailsCrud)session.get(UserDetailsCrud.class, 5);
		session.delete(user);
		*/
		
		//user = (UserDetailsCrud)session.get(UserDetailsCrud.class, 6);
		user.setUserName("updated");
		session.update(user);

		session.getTransaction().commit();
		session.close();
	}

}
